package model.util;

import java.util.ArrayList;

public class List {
    private int offset = 0;
    private final int limit = 15;
    private ArrayList<?> items;
    private Listable listable;

    public List(Listable listable){
        this.listable = listable;
    }

    public ArrayList<?> load(){
        return this.listable.loadGroup(this.offset, this.limit);
    }

    public ArrayList<?> nextPage(){
        this.offset += 15;
        this.items = this.listable.loadGroup(this.offset, this.limit);
        return this.items;
    }

    public ArrayList<?> previousPage(){
        this.offset -= 15;
        return null;
    }

    public boolean isFirstPage(){
        return (this.offset == 0);
    }
    public boolean isLastPage(){
        return (this.offset >= listable.getTotal());
    }
}
