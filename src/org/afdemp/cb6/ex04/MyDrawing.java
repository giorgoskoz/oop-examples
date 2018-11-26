package org.afdemp.cb6.ex04;

import java.util.ArrayList;
import java.util.List;
import org.afdemp.cb6.ex03.geom.Line;
import org.afdemp.cb6.ex03.geom.Point;

public class MyDrawing extends Drawing {

    @Override
    Line addLine(int x1, int x2, int y) {
       Point p1 = new Point(x1, y);
       Point p2 = new Point(x2, y);
       //Line l1 =  new Line(p1,p2);
       //SelectableLine l1 = new SelectableLine(p1, p2, false);
       InnerSelectableLine l1 = new InnerSelectableLine(p1, p2, false);
       lines.add(l1);
       return l1;
    }

    @Override
    void selectLine(Line line) {
        if (!lines.contains(line)){
            throw new RuntimeException("Invalid Line");
        }
        if(line instanceof InnerSelectableLine){
            InnerSelectableLine l = (InnerSelectableLine) line;
            l.isSelected = true;
        }else{
            throw new RuntimeException("Invalid Line");
        }
    }

    @Override
    void alignSelectedLinesToTheLeft() {
        List<InnerSelectableLine> selectedLines = new ArrayList<>();
        
        int minX = Integer.MAX_VALUE;   
        for(Line line : lines){
            InnerSelectableLine l = (InnerSelectableLine) line;
            if (l.isSelected){
                minX = getMinX(minX, l);                
                selectedLines.add(l);
            }
        }
        
        for (InnerSelectableLine line : selectedLines) {            
            Point f = line.getFirstPoint();
            Point s = line.getSecondPoint();            
            int dist = Math.abs(f.getX() - s.getX());
            f.setX(minX);
            s.setX(minX + dist);
        }
    }

    @Override
    void alignSelectedLinesToTheRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static int getMinX(int x, Line l) {
        int m = Math.min(x, l.getFirstPoint().getX());
        return Math.min(m, l.getSecondPoint().getX());
    }
    
    private static class InnerSelectableLine extends Line {
        
        private boolean isSelected;
        
        private InnerSelectableLine(Point f, Point s, boolean selected) {
            super(f, s);
            isSelected = selected;
        }
        
        public boolean getIsSelected() {
            return isSelected;
        }
    }
    
    public void printSelectedLines() {
        for (Line line : lines) {
            if ((line instanceof InnerSelectableLine) && (((InnerSelectableLine)line).getIsSelected())) {
                System.out.println(line);
            }
                
        }
        
    }
}
