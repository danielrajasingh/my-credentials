package leedcode;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.List;

// ── Data model ────────────────────────────────────────────────────────────────
class QuestionData {
    int    number;
    String topic;
    String question;
    String difficulty;
    String sheet;

    QuestionData(int number, String topic, String question,
                 String difficulty, String sheet) {
        this.number     = number;
        this.topic      = topic;
        this.question   = question;
        this.difficulty = difficulty;
        this.sheet      = sheet;
    }
}

// ── Custom table model ─────────────────────────────────────────────────────────
class QuestionTableModel extends AbstractTableModel {
    private final String[] COLUMNS = {"#", "Sheet", "Topic", "Question", "Difficulty"};
    private List<QuestionData> rows = new ArrayList<>();

    void setData(List<QuestionData> data) {
        this.rows = data;
        fireTableDataChanged();
    }

    @Override public int getRowCount()    { return rows.size(); }
    @Override public int getColumnCount() { return COLUMNS.length; }
    @Override public String getColumnName(int c) { return COLUMNS[c]; }
    @Override public boolean isCellEditable(int r, int c) { return false; }

    @Override
    public Object getValueAt(int r, int c) {
        QuestionData q = rows.get(r);
        switch (c) {
            case 0: return q.number;
            case 1: return q.sheet;
            case 2: return q.topic;
            case 3: return q.question;
            case 4: return q.difficulty;
            default: return "";
        }
    }
}

// ── Main application ───────────────────────────────────────────────────────────
public class ExcelReaderUI extends JFrame {

    // ── Palette ──────────────────────────────────────────────────────────────
    private static final Color BG        = new Color(15,  17,  23);
    private static final Color SURFACE   = new Color(24,  27,  35);
    private static final Color BORDER    = new Color(42,  46,  58);
    private static final Color FG        = new Color(220, 225, 235);
    private static final Color MUTED     = new Color(120, 130, 150);
    private static final Color ACCENT    = new Color(99,  179, 237);   // blue
    private static final Color EASY_CLR  = new Color(72,  199, 142);   // green
    private static final Color MED_CLR   = new Color(253, 203, 110);   // amber
    private static final Color HARD_CLR  = new Color(252, 110, 110);   // red
    private static final Color ALL_CLR   = new Color(176, 137, 255);   // purple
    private static final Font FONT_BODY = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font  FONT_BOLD = new Font("Segoe UI", Font.BOLD,  13);
    private static final Font  FONT_MONO = new Font("Consolas",  Font.PLAIN, 12);
    private static final Font  FONT_H1   = new Font("Segoe UI", Font.BOLD,  22);
    private static final Font  FONT_H2   = new Font("Segoe UI", Font.BOLD,  15);

    // ── State ─────────────────────────────────────────────────────────────────
    private File selectedFile;
    private final Map<String, List<QuestionData>> grouped = new LinkedHashMap<>();

    // ── UI components ─────────────────────────────────────────────────────────
    private JLabel   fileLabel;
    private JLabel   statusLabel;
    private JLabel   countAll, countEasy, countMed, countHard;
    private JTabbedPane tabs;
    private final Map<String, QuestionTableModel> models = new LinkedHashMap<>();

    // ─────────────────────────────────────────────────────────────────────────
    public ExcelReaderUI() {
        super("Excel Question Reader");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 720);
        setMinimumSize(new Dimension(860, 560));
        setLocationRelativeTo(null);
        getContentPane().setBackground(BG);
        setLayout(new BorderLayout(0, 0));

        // Init grouped map (ordered)
        grouped.put("All",    new ArrayList<>());
        grouped.put("Easy",   new ArrayList<>());
        grouped.put("Medium", new ArrayList<>());
        grouped.put("Hard",   new ArrayList<>());

        add(buildTopBar(),    BorderLayout.NORTH);
        add(buildContent(),   BorderLayout.CENTER);
        add(buildStatusBar(), BorderLayout.SOUTH);

        setVisible(true);
    }

    // ── Top bar ───────────────────────────────────────────────────────────────
    private JPanel buildTopBar() {
        JPanel bar = new JPanel(new BorderLayout(20, 0));
        bar.setBackground(SURFACE);
        bar.setBorder(new CompoundBorder(
                new MatteBorder(0, 0, 1, 0, BORDER),
                new EmptyBorder(14, 24, 14, 24)
        ));

        // Title
        JLabel title = new JLabel("⬡  Question Bank Reader");
        title.setFont(FONT_H1);
        title.setForeground(FG);
        bar.add(title, BorderLayout.WEST);

        // Right: file picker + load button
        JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        right.setOpaque(false);

        fileLabel = new JLabel("No file selected");
        fileLabel.setFont(FONT_BODY);
        fileLabel.setForeground(MUTED);

        JButton browseBtn = styledButton("Browse Excel…", ACCENT, BG);
        JButton loadBtn   = styledButton("Load & Process", EASY_CLR, BG);

        browseBtn.addActionListener(e -> browseFile());
        loadBtn.addActionListener(e   -> processFile());

        right.add(fileLabel);
        right.add(browseBtn);
        right.add(loadBtn);
        bar.add(right, BorderLayout.EAST);
        return bar;
    }

    // ── Stats bar (4 cards) ───────────────────────────────────────────────────
    private JPanel buildStatsBar() {
        JPanel row = new JPanel(new GridLayout(1, 4, 12, 0));
        row.setOpaque(false);
        row.setBorder(new EmptyBorder(18, 24, 6, 24));

        countAll  = new JLabel("0");
        countEasy = new JLabel("0");
        countMed  = new JLabel("0");
        countHard = new JLabel("0");

        row.add(statCard("All Questions",  countAll,  ALL_CLR));
        row.add(statCard("Easy",           countEasy, EASY_CLR));
        row.add(statCard("Medium",         countMed,  MED_CLR));
        row.add(statCard("Hard",           countHard, HARD_CLR));
        return row;
    }

    private JPanel statCard(String label, JLabel numLabel, Color accent) {
        JPanel card = new JPanel(new BorderLayout(0, 4));
        card.setBackground(SURFACE);
        card.setBorder(new CompoundBorder(
                new LineBorder(BORDER, 1, true),
                new EmptyBorder(14, 18, 14, 18)
        ));

        numLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        numLabel.setForeground(accent);

        JLabel lbl = new JLabel(label);
        lbl.setFont(FONT_BODY);
        lbl.setForeground(MUTED);

        // Accent left strip
        JPanel strip = new JPanel();
        strip.setBackground(accent);
        strip.setPreferredSize(new Dimension(4, 0));

        card.add(strip,    BorderLayout.WEST);
        card.add(numLabel, BorderLayout.CENTER);
        card.add(lbl,      BorderLayout.SOUTH);
        return card;
    }

    // ── Main content (stats + tabs) ───────────────────────────────────────────
    private JPanel buildContent() {
        JPanel wrapper = new JPanel(new BorderLayout(0, 0));
        wrapper.setBackground(BG);
        wrapper.add(buildStatsBar(), BorderLayout.NORTH);
        wrapper.add(buildTabs(),     BorderLayout.CENTER);
        return wrapper;
    }

    // ── Tabbed pane ───────────────────────────────────────────────────────────
    private JTabbedPane buildTabs() {
        tabs = new JTabbedPane();
        tabs.setBackground(BG);
        tabs.setForeground(FG);
        tabs.setFont(FONT_BOLD);
        tabs.setBorder(new EmptyBorder(10, 24, 16, 24));

        // One tab per difficulty + All
        String[][] defs = {
                {"All Questions", "#B089FF"},
                {"Easy",          "#48C78E"},
                {"Medium",        "#FDCB6E"},
                {"Hard",          "#FC6E6E"}
        };

        for (String[] def : defs) {
            String key     = def[0].equals("All Questions") ? "All" : def[0];
            Color  tabClr  = Color.decode(def[1]);
            QuestionTableModel model = new QuestionTableModel();
            models.put(key, model);
            JScrollPane scroll = buildTable(model, tabClr);
            tabs.addTab(def[0], scroll);
        }

        // Color tab titles
        Color[] tabColors = {ALL_CLR, EASY_CLR, MED_CLR, HARD_CLR};
        for (int i = 0; i < tabs.getTabCount(); i++) {
            JLabel lbl = new JLabel(tabs.getTitleAt(i));
            lbl.setFont(FONT_BOLD);
            lbl.setForeground(tabColors[i]);
            lbl.setBorder(new EmptyBorder(4, 8, 4, 8));
            tabs.setTabComponentAt(i, lbl);
        }
        return tabs;
    }

    // ── Table inside a scroll pane ────────────────────────────────────────────
    private JScrollPane buildTable(QuestionTableModel model, Color accent) {
        JTable table = new JTable(model);
        table.setBackground(SURFACE);
        table.setForeground(FG);
        table.setFont(FONT_BODY);
        table.setGridColor(BORDER);
        table.setRowHeight(32);
        table.setShowVerticalLines(true);
        table.setShowHorizontalLines(true);
        table.setSelectionBackground(new Color(accent.getRed(), accent.getGreen(), accent.getBlue(), 60));
        table.setSelectionForeground(FG);
        table.setAutoCreateRowSorter(true);

        // Header
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(30, 33, 43));
        header.setForeground(accent);
        header.setFont(FONT_BOLD);
        header.setBorder(new MatteBorder(0, 0, 1, 0, BORDER));

        // Column widths
        int[] widths = {50, 110, 130, 0, 90};   // 0 = stretch
        TableColumnModel tcm = table.getColumnModel();
        for (int i = 0; i < widths.length; i++) {
            if (widths[i] > 0) {
                tcm.getColumn(i).setPreferredWidth(widths[i]);
                tcm.getColumn(i).setMaxWidth(widths[i] == 50 ? 60 : 200);
            }
        }

        // Alternating row renderer
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable t, Object val, boolean sel, boolean foc, int row, int col) {
                super.getTableCellRendererComponent(t, val, sel, foc, row, col);
                setFont(col == 3 ? FONT_MONO : FONT_BODY);
                if (!sel) {
                    setBackground(row % 2 == 0 ? SURFACE : new Color(28, 31, 41));
                    setForeground(col == 4 ? diffColor((String) val) : FG);
                }
                setBorder(new EmptyBorder(0, 8, 0, 8));
                return this;
            }
        });

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBackground(BG);
        scroll.getViewport().setBackground(SURFACE);
        scroll.setBorder(new LineBorder(BORDER, 1, true));
        return scroll;
    }

    private Color diffColor(Object val) {
        if (val == null) return FG;
        switch (val.toString()) {
            case "Easy":   return EASY_CLR;
            case "Medium": return MED_CLR;
            case "Hard":   return HARD_CLR;
            default:       return FG;
        }
    }

    // ── Status bar ────────────────────────────────────────────────────────────
    private JPanel buildStatusBar() {
        JPanel bar = new JPanel(new BorderLayout());
        bar.setBackground(new Color(18, 21, 29));
        bar.setBorder(new CompoundBorder(
                new MatteBorder(1, 0, 0, 0, BORDER),
                new EmptyBorder(6, 20, 6, 20)
        ));
        statusLabel = new JLabel("Ready — browse an Excel file and click Load & Process.");
        statusLabel.setFont(FONT_BODY);
        statusLabel.setForeground(MUTED);
        bar.add(statusLabel, BorderLayout.WEST);
        return bar;
    }

    // ── File browser ──────────────────────────────────────────────────────────
    private void browseFile() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Excel files (*.xlsx)", "xlsx"));
        fc.setAcceptAllFileFilterUsed(false);
        int result = fc.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
            fileLabel.setText(selectedFile.getName());
            fileLabel.setForeground(ACCENT);
            setStatus("File selected: " + selectedFile.getAbsolutePath());
        }
    }

    // ── Process the Excel file ────────────────────────────────────────────────
    private void processFile() {
        if (selectedFile == null) {
            setStatus("⚠  Please select an Excel file first.");
            JOptionPane.showMessageDialog(this,
                    "Please browse and select an Excel file first.",
                    "No File", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Clear previous
        for (List<QuestionData> list : grouped.values()) list.clear();
        setStatus("Processing…");

        SwingWorker<Void, String> worker = new SwingWorker<>() {
            int warnings = 0;

            @Override
            protected Void doInBackground() throws Exception {
                try (FileInputStream fis     = new FileInputStream(selectedFile);
                     Workbook         wb     = new XSSFWorkbook(fis)) {

                    publish("Reading " + wb.getNumberOfSheets() + " sheet(s)…");

                    for (int s = 0; s < wb.getNumberOfSheets(); s++) {
                        Sheet sheet = wb.getSheetAt(s);
                        publish("Sheet: " + sheet.getSheetName());
                        Iterator<Row> rows = sheet.iterator();
                        if (rows.hasNext()) rows.next(); // skip header

                        while (rows.hasNext()) {
                            Row row = rows.next();
                            if (isRowEmpty(row)) continue;

                            int    num   = getNumericCell(row.getCell(0));
                            String topic = getStringCell(row.getCell(1));
                            String q     = getStringCell(row.getCell(2));
                            String diff  = capitalize(getStringCell(row.getCell(3)).trim());

                            QuestionData qd = new QuestionData(num, topic, q, diff, sheet.getSheetName());
                            grouped.get("All").add(qd);

                            if (grouped.containsKey(diff)) {
                                grouped.get(diff).add(qd);
                            } else {
                                warnings++;
                                publish("  ⚠ Unknown difficulty \"" + diff + "\" row " + (row.getRowNum() + 1));
                            }
                        }
                    }
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                setStatus(chunks.get(chunks.size() - 1));
            }

            @Override
            protected void done() {
                try {
                    get(); // surface exceptions
                    refreshTables();
                    String msg = "Done! " + grouped.get("All").size() + " question(s) loaded.";
                    if (warnings > 0) msg += "  (" + warnings + " row(s) with unknown difficulty skipped)";
                    setStatus(msg);
                } catch (Exception ex) {
                    setStatus("Error: " + ex.getMessage());
                    JOptionPane.showMessageDialog(ExcelReaderUI.this,
                            "Could not read file:\n" + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        worker.execute();
    }

    // ── Push data to tables and stat cards ────────────────────────────────────
    private void refreshTables() {
        String[] keys   = {"All", "Easy", "Medium", "Hard"};
        JLabel[] counts = {countAll, countEasy, countMed, countHard};

        for (int i = 0; i < keys.length; i++) {
            List<QuestionData> list = grouped.get(keys[i]);
            models.get(keys[i]).setData(list);
            counts[i].setText(String.valueOf(list.size()));
        }
    }

    // ── Helpers ───────────────────────────────────────────────────────────────
    private void setStatus(String msg) {
        SwingUtilities.invokeLater(() -> statusLabel.setText(msg));
    }

    private static String getStringCell(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:  return cell.getStringCellValue().trim();
            case NUMERIC: return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try { return cell.getStringCellValue().trim(); }
                catch (Exception e) { return String.valueOf((int) cell.getNumericCellValue()); }
            default: return "";
        }
    }

    private static int getNumericCell(Cell cell) {
        if (cell == null) return 0;
        switch (cell.getCellType()) {
            case NUMERIC: return (int) cell.getNumericCellValue();
            case STRING:
                try { return Integer.parseInt(cell.getStringCellValue().trim()); }
                catch (NumberFormatException e) { return 0; }
            default: return 0;
        }
    }

    private static boolean isRowEmpty(Row row) {
        if (row == null) return true;
        for (Cell c : row)
            if (c != null && c.getCellType() != CellType.BLANK && !getStringCell(c).isEmpty())
                return false;
        return true;
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    private static JButton styledButton(String text, Color bg, Color fg) {
        JButton btn = new JButton(text) {
            @Override protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color base = getBackground();
                if (getModel().isRollover())
                    base = base.brighter();
                g2.setColor(base);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setForeground(fg);
        btn.setBackground(bg);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setOpaque(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setBorder(new EmptyBorder(8, 18, 8, 18));
        return btn;
    }

    // ── Entry point ───────────────────────────────────────────────────────────
    public static void main(String[] args) {
        // Dark title bar on Windows (Java 17+)
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception ignored) {}

        // Override key LAF colors for dark feel
        UIManager.put("TabbedPane.background",        new Color(15, 17, 23));
        UIManager.put("TabbedPane.foreground",         new Color(220, 225, 235));
        UIManager.put("TabbedPane.selected",           new Color(24, 27, 35));
        UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.put("OptionPane.background",         new Color(24, 27, 35));
        UIManager.put("Panel.background",              new Color(24, 27, 35));

        SwingUtilities.invokeLater(ExcelReaderUI::new);
    }
}