package me.wild.objects;

public enum ScreenSize {
    PHONE(5, 9, "Phone"),   // 5 rows, 9 columns
    PC(6, 9, "PC");         // 6 rows, 9 columns

    private final int rows;
    private final int columns;
    private final String displayName;

    ScreenSize(int rows, int columns, String displayName) {
        this.rows = rows;
        this.columns = columns;
        this.displayName = displayName;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getTotalSize() {
        return rows * columns;
    }

    public String getDisplayName() {
        return displayName;
    }
}
