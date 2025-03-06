package tictactoe.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> grid;
    private int size;

    public Board(int size) {
        this.size = size;
        initializeGrid();
    }
    private void initializeGrid() {
        this.grid = new ArrayList<List<Cell>>();
        for (int i = 0; i < size; i++) {
            this.grid.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                this.grid.get(i).add(new Cell(i, j));
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }
}
