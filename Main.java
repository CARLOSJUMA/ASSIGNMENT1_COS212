public class Main {
    // Output is in output.txt
    public static void main(String[] args) {
        Maze m = new Maze("input.txt");
        System.out.println(m.toString());
        System.out.println(m.validStarts(0, 0));
    }
}

// import org.junit.Test;
// import static org.junit.Assert.*;

// public class Main {

//     @Test
//     public void testAppend() {
//         LinkedList list = new LinkedList();
//         list.append(1, 2);
//         list.append(3, 4);
//         System.out.println(list.toString());
//         assertEquals("[1,2] -> [3,4]", list.toString());
//     }

//     @Test
//     public void testAppendList() {
//         LinkedList list1 = new LinkedList();
//         list1.append(1, 2);
//         LinkedList list2 = new LinkedList();
//         list2.append(3, 4);
//         list2.append(5, 6);
//         list1.appendList(list2);
//         System.out.println(list1.toString());
//         assertEquals("[1,2] -> [3,4] -> [5,6]", list1.toString());
//     }

//     @Test
//     public void testContains() {
//         LinkedList list = new LinkedList();
//         list.append(1, 2);
//         list.append(3, 4);
//         assertTrue(list.contains(1, 2));
//         assertFalse(list.contains(5, 6));
//     }

//     @Test
//     public void testToStringEmptyList() {
//         LinkedList list = new LinkedList();
//         assertEquals("Empty List", list.toString());
//     }

//     @Test
//     public void testLength() {
//         LinkedList list = new LinkedList();
//         list.append(1, 2);
//         list.append(3, 4);
//         assertEquals(2, list.length());
//     }

//     @Test
//     public void testReversed() {
//         LinkedList list = new LinkedList();
//         list.append(1, 2);
//         list.append(3, 4);
//         LinkedList reversedList = list.reversed();
//         assertEquals("[3,4] -> [1,2]", reversedList.toString());
//     }

//     @Test
//     public void testMazeToString() {
//         String[] map = {"###", "# #", "###"};
//         Maze maze = new Maze(map);
//         String expected = "###\n# #\n###";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeToStringWithEmptyMap() {
//         String[] map = {};
//         Maze maze = new Maze(map);
//         assertEquals("", maze.toString());
//     }

//     @Test
//     public void testMazeToStringWithSingleLineMap() {
//         String[] map = {"###"};
//         Maze maze = new Maze(map);
//         assertEquals("###", maze.toString());
//     }

//     @Test
//     public void testMazeToStringWithEmptyLine() {
//         String[] map = {"###", "", "###"};
//         Maze maze = new Maze(map);
//         String expected = "###\n\n###";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeWithExistingFile() {
//         Maze maze = new Maze("existing_maze.txt");
//         assertNotNull(maze);
//         // Assuming the content of existing_maze.txt is "X-X\n-X-\nX-X"
//         String expected = "X-X\n-X-\nX-X";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeWithNonExistentFile1() {
//         Maze maze = new Maze("nonexistent_maze.txt");
//         assertEquals("Empty Map", maze.toString());
//     }

//     @Test
//     public void testMazeCopyConstructor() {
//         Maze originalMaze = new Maze("existing_maze.txt");
//         Maze copiedMaze = new Maze(originalMaze);
//         assertNotSame(originalMaze, copiedMaze);
//         assertEquals(originalMaze.toString(), copiedMaze.toString());
//     }


//     @Test
//     public void testMazeWithFile() {
//         Maze maze = new Maze("maze.txt");
//         assertNotNull(maze);
//         // Assuming the content of maze.txt is XXX\nX-X\nXXX///
//         String expected = "XXX\nX-X\nXXX";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeWithNonExistentFile() {
//         Maze maze = new Maze("nonexistent.txt");
//         assertEquals("Empty Map", maze.toString()); // Since file not found, map should be empty
//     }
// }


// import org.junit.Test;
// import static org.junit.Assert.*;

// public class Main {

//     @Test
//     public void testMazeWithFile() {
//         Maze maze = new Maze("maze.txt");
//         assertNotNull(maze);
//         // Assuming the content of maze.txt is:
//         // 3
//         // XXX
//         // X-X
//         // XXX
//         String expected = "XXX\nX-X\nXXX";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeWithNonExistentFile() {
//         Maze maze = new Maze("nonexistent.txt");
//         assertEquals("Empty Map", maze.toString()); // Since file not found, map should be empty
//     }

//     @Test
//     public void testMazeWithInvalidFile() {
//         Maze maze = new Maze("invalid_maze.txt");
//         assertNotNull(maze);
//         // Assuming the content of invalid_maze.txt is:
//         // 3
//         // XXX$
//         // X-X
//         // XXX
//         // The maze should ignore the invalid character '$'
//         String expected = "XXX\nX-X\nXXX";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeWithTooManyLines() {
//         Maze maze = new Maze("too_many_lines.txt");
//         assertNotNull(maze);
//         // Assuming the content of too_many_lines.txt is:
//         // 3
//         // XXX
//         // X-X
//         // XXX
//         // X-X
//         // The maze should ignore the extra line 'X-X'
//         String expected = "XXX\nX-X\nXXX";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeWithTooFewLines() {
//         Maze maze = new Maze("XXX\nX-X");
//         assertNotNull(maze);
//         // Assuming the content of too_few_lines.txt is:
//         // 3
//         // XXX
//         // X-X
//         // The maze should ignore the missing line
//         String expected = "XXX\nX-X";
//         assertEquals(expected, maze.toString());
//     }

//     @Test
//     public void testMazeWithInvalidRowCount() {
//         Maze maze = new Maze("invalid_row_count.txt");
//         assertNotNull(maze);
//         // Assuming the conte head nt of invalid_row_count.txt is:
//         // -1
//         // XXX
//         // X-X
//         // XXX
//         // The maze should ignore the invalid row count and create an empty maze
//         assertEquals("Empty Map", maze.toString());
//     }
// }