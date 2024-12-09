package pr20;

// Обобщенный класс Matrix
public class Matrix<T extends Number> {
    private T[][] matrix;
    private int rows;
    private int columns;

    // Конструктор для создания матрицы с заданным количеством строк и столбцов
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        matrix = (T[][]) new Number[rows][columns];
    }

    // Метод для заполнения матрицы значениями
    public void fillMatrix(T[][] values) {
        if (values.length == rows && values[0].length == columns) {
            matrix = values;
        } else {
            System.out.println("Размеры матрицы не совпадают!");
        }
    }

    // Метод для получения элемента матрицы
    public T get(int row, int col) {
        return matrix[row][col];
    }

    // Метод для установки элемента матрицы
    public void set(int row, int col, T value) {
        matrix[row][col] = value;
    }

    // Метод для сложения матриц
    public Matrix<T> add(Matrix<T> other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Размеры матриц должны совпадать для сложения.");
        }
        Matrix<T> result = new Matrix<>(this.rows, this.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double sum = this.get(i, j).doubleValue() + other.get(i, j).doubleValue();
                result.set(i, j, (T) Double.valueOf(sum));
            }
        }
        return result;
    }

    // Метод для вычитания матриц
    public Matrix<T> subtract(Matrix<T> other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Размеры матриц должны совпадать для вычитания.");
        }
        Matrix<T> result = new Matrix<>(this.rows, this.columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double diff = this.get(i, j).doubleValue() - other.get(i, j).doubleValue();
                result.set(i, j, (T) Double.valueOf(diff));
            }
        }
        return result;
    }

    // Метод для умножения матриц
    public Matrix<T> multiply(Matrix<T> other) {
        if (this.columns != other.rows) {
            throw new IllegalArgumentException("Число столбцов первой матрицы должно быть равно числу строк второй.");
        }
        Matrix<T> result = new Matrix<>(this.rows, other.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                double sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.get(i, k).doubleValue() * other.get(k, j).doubleValue();
                }
                result.set(i, j, (T) Double.valueOf(sum));
            }
        }
        return result;
    }

    // Метод для транспонирования матрицы
    public Matrix<T> transpose() {
        Matrix<T> result = new Matrix<>(this.columns, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.set(j, i, this.get(i, j));
            }
        }
        return result;
    }

    // Метод для вывода матрицы
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(get(i, j) + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Пример использования
        Integer[][] values1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Integer[][] values2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        Matrix<Integer> matrix1 = new Matrix<>(3, 3);
        matrix1.fillMatrix(values1);

        Matrix<Integer> matrix2 = new Matrix<>(3, 3);
        matrix2.fillMatrix(values2);

        System.out.println("Matrix 1:");
        matrix1.printMatrix();
        System.out.println("Matrix 2:");
        matrix2.printMatrix();

        // Операция сложения
        Matrix<Integer> resultAdd = matrix1.add(matrix2);
        System.out.println("Sum of matrices:");
        resultAdd.printMatrix();

        // Операция вычитания
        Matrix<Integer> resultSub = matrix1.subtract(matrix2);
        System.out.println("Subtraction of matrices:");
        resultSub.printMatrix();

        // Операция умножения
        Matrix<Integer> resultMul = matrix1.multiply(matrix2);
        System.out.println("Multiplication of matrices:");
        resultMul.printMatrix();

        // Операция транспонирования
        Matrix<Integer> resultTranspose = matrix1.transpose();
        System.out.println("Transpose of Matrix 1:");
        resultTranspose.printMatrix();
    }
}
