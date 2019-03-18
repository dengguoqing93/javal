package tree;

/**
 * 二叉搜索树
 *
 * @author dengguoqing
 * @date 2019/2/25
 */
public abstract class Tree<A extends Comparable<A>> {
    private static Tree EMPTY = new Empty();

    /**
     * 返回根的值
     *
     * @return A
     */
    public abstract A value();

    /**
     * 左侧树
     *
     * @return 树
     */
    abstract Tree<A> left();

    /**
     * 右侧二叉树
     *
     * @return tree
     */
    abstract Tree<A> right();


    /**
     * 在树中插入一个值
     *
     * @param value 待插入的值
     * @return 更新后的数
     */
    public abstract Tree<A> insert(A value);

    /**
     * 表示一个空树
     *
     * @param <A>
     */
    private static class Empty<A extends Comparable<A>> extends Tree<A> {
        @Override
        public A value() {
            throw new IllegalStateException("value() called on empty");
        }

        @Override
        Tree<A> left() {
            throw new IllegalStateException("left() called on empty");
        }

        @Override
        Tree<A> right() {
            throw new IllegalStateException("left() called on empty");
        }

        @Override
        public Tree<A> insert(A value) {
            return new T<>(empty(), value, empty());
        }

        @Override
        public String toString() {
            return "E";
        }
    }

    private static class T<A extends Comparable<A>> extends Tree<A> {

        private final Tree<A> left;
        private final Tree<A> right;
        private final A value;

        public T(Tree<A> left, A value, Tree<A> right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        @Override
        public A value() {
            return value;
        }

        @Override
        Tree<A> left() {
            return left;
        }

        @Override
        Tree<A> right() {
            return right;
        }

        @Override
        public Tree<A> insert(A value) {
            if (value.compareTo(this.value) < 0) {
                return new T<>(left.insert(value), this.value, right);
            } else {
                return value.compareTo(this.value) > 0 ?
                        new T<>(left, this.value, right.insert(value)) :
                        new T<>(left, value, right);
            }

        }

        @Override
        public String toString() {
            return String.format("(T %s %s %s）", left, value, right);
        }
    }

    /**
     * 获取一个空树
     *
     * @param <A> 泛型值
     * @return 空树
     */
    public static <A extends Comparable<A>> Tree<A> empty() {
        return EMPTY;
    }

}
