package main.java.bupt.wxy.math;

/**
 * Created by xiyuanbupt on 3/24/17.
 223. Rectangle Area
 Difficulty: Medium
 Find the total area covered by two rectilinear rectangles in a 2D plane.

 Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

 Rectangle Area
 Assume that the total area is never beyond the maximum possible value of int.
 */
public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = max(A, E), right = max(min(C, G), left);
        int bottom = max(B, F), top = max(bottom, min(H, D));
        return (C-A) * (D-B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }

    private int max(int x, int y){
        return x>y?x:y;
    }

    private int min(int x, int y){
        return x>y?y:x;
    }
}
