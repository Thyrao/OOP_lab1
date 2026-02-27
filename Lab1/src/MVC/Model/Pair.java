package MVC.Model;

class Pair<V, S> {
    V v;
    S s;
    public Pair(V v, S s){
        this.v = v;
        this.s = s;
    }

    public V getFirst(){
        return v;
    }
    public S getLast(){
        return s;
    }

}
