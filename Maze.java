import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    private String[] map;

    private void readInput(Scanner Reader,int index){
        if(index == map.length){
            return;
        }
        if(Reader.hasNextLine()){ 
            String line = Reader.nextLine();
            map[index] = line;
            readInput(Reader, index+1); 
        }
    }

    public Maze(String filename) {
        try {
            File  mazeFile = new File(filename);
            Scanner Reader = new Scanner(mazeFile);
            map = new String[Integer.parseInt(Reader.nextLine())];
            readInput(Reader, 0);
        } catch (FileNotFoundException e) {
            map = new String[0];
        }
    }

    public Maze(Maze other) {
        this.map=other.map;
    }

    private String convertString(String returnString, int index){
        if(index == map.length)
            return returnString;
        else if(index == map.length-1){
            returnString += map[index];
            return returnString;
        }
        else if(index<map.length-1){
            returnString += map[index] + "\n";
        }
        return convertString(returnString, index+1);
    }

    @Override
    public String toString() {
        if(map.length == 0){
            return "Empty Map";
        }
        String retruString="";
        return convertString(retruString, 0);
    }

    // public boolean validSolution(int startX, int startY, int goalX, int goalY, LinkedList path) {
    //     return false;
    // }

    // public String solve(int x, int y, int goalX, int goalY) {
    //     return "";
    // }

    // public LinkedList validStarts(int x, int y) {
    //     return null;
    // }
    
    public boolean validSolution(int startX, int startY, int goalX, int goalY, LinkedList path) {
        // Check if the path is empty or if the start and end coordinates don't match
        if (path.head == null || path.head.x != startX || path.head.y != startY || getNodeAt(path, path.length() - 1).x != goalX || getNodeAt(path, path.length() - 1).y != goalY) {
            return false;
        }
    
        // Check if the path contains any walls or out-of-bounds coordinates
        CoordinateNode current = path.head;
        while (current != null) {
            if (current.x < 0 || current.x >= map.length || current.y < 0 || current.y >= map[0].length() || map[current.x].charAt(current.y) == 'X') {
                return false;
            }
            current = current.next;
        }
    
        // Check if the path moves more than one step at a time or moves diagonally
        current = path.head;
        CoordinateNode prev = null;
        while (current != null) {
            if (prev != null) {
                int dx = Math.abs(current.x - prev.x);
                int dy = Math.abs(current.y - prev.y);
                if (dx > 1 || dy > 1 || (dx == 1 && dy == 1)) {
                    return false;
                }
            }
            prev = current;
            current = current.next;
        }
    
        // Check if the path doubles back on itself
        boolean[] visited = new boolean[map.length * map[0].length()];
        current = path.head;
        while (current != null) {
            int index = current.x * map[0].length() + current.y;
            if (visited[index]) {
                return false;
            }
            visited[index] = true;
            current = current.next;
        }
    
        return true;
    }
    
    private CoordinateNode getNodeAt(LinkedList list, int index) {
        CoordinateNode current = list.head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }
    
    public String solve(int startX, int startY, int goalX, int goalY) {
        LinkedList solution = new LinkedList();
        return solveHelper(startX, startY, goalX, goalY, solution) ? solution.toString() : "No solution found";
    }
    
    private boolean solveHelper(int x, int y, int goalX, int goalY, LinkedList path) {
        if (x == goalX && y == goalY) {
            path.append(x, y);
            return true;
        }
    
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length() || map[x].charAt(y) == 'X') {
            return false;
        }
    
        path.append(x, y);
    
        boolean found = solveHelper(x + 1, y, goalX, goalY, path) ||
                        solveHelper(x - 1, y, goalX, goalY, path) ||
                        solveHelper(x, y + 1, goalX, goalY, path) ||
                        solveHelper(x, y - 1, goalX, goalY, path);
    
        if (!found) {
            path.head = removeLastNode(path.head);
        }
    
        return found;
    }
    
    private CoordinateNode removeLastNode(CoordinateNode head) {
        if (head == null || head.next == null) {
            return head; // Return the current head if the list is empty or has only one node
        }
    
        CoordinateNode curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
    
        curr.next = null; // Remove the reference to the last node
        return head;
    }
    
    public LinkedList validStarts(int x, int y) {
        LinkedList starts = new LinkedList();
        boolean[][] visited = new boolean[map.length][map[0].length()];
        validStartsHelper(x, y, starts, visited);
        return starts;
    }
    
    private void validStartsHelper(int x, int y, LinkedList starts, boolean[][] visited) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length() || map[x].charAt(y) == 'X' || visited[x][y]) {
            return;
        }
    
        visited[x][y] = true; // Mark the current position as visited
    
        if (map[x].charAt(y) == 'S') {
            starts.append(x, y);
            return; // Stop recursion if a valid start position is found
        }
    
        validStartsHelper(x + 1, y, starts, visited);
        validStartsHelper(x - 1, y, starts, visited);
        validStartsHelper(x, y + 1, starts, visited);
        validStartsHelper(x, y - 1, starts, visited);
    }
}