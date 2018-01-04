package model;

import java.util.Random;

public class Block {
	public enum Tetris_block {
		Empty, Z, S, I, T, O, L, J 
	}
	
	private Tetris_block blockShape;
	private int[][] coordinates;
	private int[][][] coordTable;
	
	public Block() {
		coordinates = new int[4][2];
		coordTable = new int [][][] {
			{{0, 0}, {0, 0}, {0, 0}, {0, 0}},		// Empty
            {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},	// Z
            {{0, -1}, {0, 0}, {1, 0}, {1, 1}},		// S
            {{0, -1}, {0, 0}, {0, 1}, {0, 2}},		// I
            {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},		// T
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},		// O
            {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},	// L
            {{1, -1}, {0, -1}, {0, 0}, {0, 1}}		// J
		};
		setBlockShape(Tetris_block.Empty);
	}
	
	public void setBlockShape(Tetris_block newShape) {
		for (int i = 0; i < 4; i++) {
			System.arraycopy(coordTable[newShape.ordinal()][i], 0, coordinates[i], 0, 2);
		}
		this.blockShape = newShape;
	}
	
	private void setX(int index, int x) {
		coordinates[index][0] = x;
	}
	
	private void setY(int index, int y ) {
		coordinates[index][1] = y;
	}
	
	public int x (int index) {
		return coordinates[index][0];
	}
	
	public int y (int index) {
		return coordinates[index][1];
	}
	
	public Tetris_block getBlockShape() {
		return blockShape;
	}
	
	public void setRandomShape() {
		Random random = new Random();
		int x  = Math.abs(random.nextInt()) % 7 + 1;
		Tetris_block[] values = Tetris_block.values();
		setBlockShape(values[x]);
	}
	
	public int xMin() {
        int m = coordinates[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coordinates[i][0]);
        }
        return m;
    }


    public int yMin() {
        int m = coordinates[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coordinates[i][1]);
        }
        return m;
    }

	public Block rotateRight() {
		if (blockShape == Tetris_block.O) {
			return this;
		}
		
		Block result = new Block();
		result.blockShape = blockShape;
		
		for (int i = 0; i < 4; ++i) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
	}
}
