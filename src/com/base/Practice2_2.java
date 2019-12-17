package com.base;


import java.io.IOException;
import java.util.*;

public class Practice2_2 {

    static class Point implements Comparable {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Object o) {
            Point pN = ((Point) o);
            if (pN.x == x) {
                return y - pN.y;
            } else {
                return x - pN.x;
            }
        }

        public String toString() {
            return x + " " + y;
        }

        public boolean equals(Object o) {
            return ((Point) o).x == x && ((Point) o).y == y;
        }

        @Override
        public int hashCode() {
            return (10000 * x) + y;
        }
    }

    public static List<Point> findHull(Point[] points) {
        Point start = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < start.x) {
                start = points[i];
            }
        }
        Point current = start;
        Set<Point> result = new HashSet<>();
        result.add(start);
        List<Point> collinearPoints = new ArrayList<>();
        while (true) {
            Point nextTarget = points[0];
            for (int i = 1; i < points.length; i++) {
                if (points[i] == current) {
                    continue;
                }
                int val = cross(current, nextTarget, points[i]);
                if (val > 0) {
                    nextTarget = points[i];
                    collinearPoints = new ArrayList<>();
                } else if (val == 0) {
                    if (distance(current, nextTarget, points[i]) < 0) {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else {
                        collinearPoints.add(points[i]);
                    }
                }
            }

            for (Point p : collinearPoints) {
                result.add(p);
            }
            if (nextTarget == start) {
                break;
            }
            result.add(nextTarget);
            current = nextTarget;
        }
        return new ArrayList<>(result);

    }


    public static int cross(Point a, Point b, Point c) {
        int abx = b.x - a.x;
        int aby = b.y - a.y;
        int acx = c.x - a.x;
        int acy = c.y - a.y;
        return Integer.compare((abx * acy - aby * acx), 0);
    }

    public static int distance(Point a, Point b, Point c) {
        int abx = b.x - a.x;
        int aby = b.y - a.y;
        int acx = c.x - a.x;
        int acy = c.y - a.y;
        return Integer.compare(abx * abx + aby * aby - acx * acx - acy * acy, 0);

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t < 3) {
                System.out.println(-1);
                for (int j = 0; j < t; j++) {
                    sc.nextInt();
                    sc.nextInt();
                }
                continue;
            }
            Point[] pts = new Point[t];
            for (int j = 0; j < t; j++) {
                pts[j] = new Point(sc.nextInt(), sc.nextInt());
            }
            List<Point> hull = findHull(pts);
            Collections.sort(hull);
            //System.out.println(hull);
            if (hull.size() > 2) {
                for (int j = 0; j < hull.size(); j++) {
                    System.out.print(hull.get(j) + (j == hull.size() - 1 ? "" : ", "));
                }
            } else {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}






















