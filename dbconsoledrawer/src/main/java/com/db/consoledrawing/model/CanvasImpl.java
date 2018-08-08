package com.db.consoledrawing.model;

import com.db.consoledrawing.exception.InvalidEntityException;
import com.db.consoledrawing.interfaces.Canvas;
import com.db.consoledrawing.interfaces.Entity;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanvasImpl implements Canvas {

    private static final Logger LOGGER = Logger.getLogger(CanvasImpl.class.getName());

    private static final char HORIZONTAL_EDGE_CHAR = '-';
    private static final char VERTICAL_EDGE_CHAR = '|';
    private static final char LINE_CHAR = 'x';

    private final char[][] cachedCanvasArray;
    private final int width;
    private final int height;
    // to support advanced operation such as: undo, redo
    private List<Entity> entities;
    private final String horizontalEdge;

    public CanvasImpl(int w, int h) {
        width = w;
        height = h;
        entities = new LinkedList<>();

        cachedCanvasArray = new char[this.height][this.width];
        Arrays.stream(cachedCanvasArray).forEach(chars -> Arrays.fill(chars, ' '));

        horizontalEdge = Stream.generate(() -> String.valueOf(HORIZONTAL_EDGE_CHAR)).limit(width + 2).collect(Collectors.joining());
    }

    @Override
    public void addEntity(Entity entity) throws InvalidEntityException {
        entities.add(entity);
        if (entity instanceof Line) {
            addLine((Line) entity);
        } else if (entity instanceof Rectangle) {
            addRectangle((Rectangle) entity);
        } else if (entity instanceof BucketFill) {
            addBucketFill((BucketFill) entity);
        }
    }

    @Override
    public String render() {

        StringBuilder builder = new StringBuilder();
        builder.append(horizontalEdge).append("\n");
        int i = 0;
        if (i < this.height) {
            do {
                builder.append(VERTICAL_EDGE_CHAR);
                for (int j = 0; j < this.width; j++) {
                    builder.append(cachedCanvasArray[i][j]);
                }
                builder.append(VERTICAL_EDGE_CHAR);
                builder.append("\n");
                i++;
            } while (i < this.height);
        }
        builder.append(horizontalEdge);
        return builder.toString();
    }

    private void addBucketFill(BucketFill bucketFill) {
        if (isOutside(bucketFill.getX(), bucketFill.getY())) {
            try {
                throw new InvalidEntityException("Bucket fill point is outside of canvas");
            } catch (InvalidEntityException e) {
            }
        }
        fillBucket(bucketFill.getX(), bucketFill.getY(), bucketFill.getCharacter());
    }

    private void addRectangle(Rectangle rec) throws InvalidEntityException {

        if (isOutside(rec.getX1(), rec.getY1())) {
            throw new InvalidEntityException("Rectangle is outside of canvas");
        }
        drawRectangle(rec.getX1(), rec.getY1(), rec.getX2(), rec.getY2());
    }

    private void addLine(Line line) throws InvalidEntityException {
        if (isOutside(line.getX1(), line.getY1())) {
            throw new InvalidEntityException("Line is outside of canvas");
        }

        //trim the part the is outside
        if (line.getX2() >= width) {
            line.setX2(width);
        }
        if (line.getY2() >= height) {
            line.setY2(height);
        }
        drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
    }

    private void drawLine(int x1, int y1, int x2, int y2) {
        //row by row
        for (int row = y1 - 1; row <= y2 - 1 && row < height; row++) {
            //col by col
            for (int col = x1 - 1; col <= x2 - 1 && col < width; col++) {
                cachedCanvasArray[row][col] = CanvasImpl.LINE_CHAR;
            }
        }
    }

    private void fillBucket(int x, int y, char mChar) {

        char originalChar = cachedCanvasArray[y - 1][x - 1];
        Stack<Point> stack = new Stack<>();
        stack.add(new Point(y - 1, x - 1));
        //BFS traversal
        while (!stack.isEmpty()) {
            Point pop = stack.pop();
            int x1 = pop.getX();
            int y1 = pop.getY();
            if (cachedCanvasArray[x1][y1] == originalChar) {
                cachedCanvasArray[x1][y1] = mChar;
            }
            if (x1 - 1 >= 0 && cachedCanvasArray[x1 - 1][y1] == originalChar) {
                stack.add(new Point(x1 - 1, y1));
            }
            if (x1 + 1 < height && cachedCanvasArray[x1 + 1][y1] == originalChar) {
                stack.add(new Point(x1 + 1, y1));
            }
            if (y1 - 1 >= 0 && cachedCanvasArray[x1][y1 - 1] == originalChar) {
                stack.add(new Point(x1, y1 - 1));
            }
            if (y1 + 1 < width && cachedCanvasArray[x1][y1 + 1] == originalChar) {
                stack.add(new Point(x1, y1 + 1));
            }
        }
    }

    private void drawRectangle(int x1, int y1, int x2, int y2) {
        //top edge
        drawLine(x1, y1, x2, y1);
        //right edge
        drawLine(x1, y1, x1, y2);
        //bottom edge
        drawLine(x2, y1, x2, y2);
        //right edge
        drawLine(x1, y2, x2, y2);
    }

    private boolean isOutside(int x, int y) {
        return x < 1 || x >= width || y < 1 || y >= height;
    }
}
