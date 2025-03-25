public class MyBSTNode<K, V> {
    private K key;
    private V value;
    private MyBSTNode parent;
    private MyBSTNode left;
    private MyBSTNode right;
    public MyBSTNode<K, V> successor(){
        MyBSTNode curr = this;
        if(curr.right == null){
            while(curr != curr.parent.left){
                curr = curr.parent;
            }
            return curr.parent;
        }
        else if(curr.right != null){
            curr = curr.right;
            while(curr != null){
                curr = curr.left;
            }
            return curr.parent;
        }
        else{
            return null;
        }
    }
}
