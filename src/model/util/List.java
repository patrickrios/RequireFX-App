package model.util;

import java.util.ArrayList;

public class List {

    private int offset = 1;
    private final int limit = 15;
    private ArrayList<?> items;
    private Listable listable;

    public List(Listable listable){
        this.listable = listable;
    }

    public ArrayList<?> nextPage(){
        this.offset += 15;
        return listable.loadGroup(this.offset, this.limit);
    }

    public ArrayList<?> previousPage(){
        this.offset -= 15;
        return previousPage();
    }

    public boolean isFirstPage(){
        return (this.offset == 0);
    }
    public boolean isLastPage(){
        return (this.offset >= listable.getTotal());
    }
}
