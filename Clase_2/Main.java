package Clase_2;

// Clase para representar un nodo del árbol
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

// Clase para representar el Árbol Binario de Búsqueda
class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Método para insertar un nodo en el árbol (opcional para pruebas)
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Inserción recursiva de un valor
    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Implementación del método getHeight usando Divide y Conquista
    public int getHeight() {
        return getHeightRec(root);
    }

    // Método recursivo para obtener la altura de un subárbol
    private int getHeightRec(TreeNode node) {
        if (node == null) {
            return -1;  // Un árbol vacío tiene altura -1
        }
        // Divide y conquista: calcula la altura de los subárboles izquierdo y derecho
        int leftHeight = getHeightRec(node.left);
        int rightHeight = getHeightRec(node.right);
        
        // Conquista: la altura del nodo actual es el máximo de las alturas de los subárboles, más uno
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(8);
        bst.insert(1);
        bst.insert(4);

        System.out.println("Altura del Árbol Binario de Búsqueda: " + bst.getHeight());
    }
}

