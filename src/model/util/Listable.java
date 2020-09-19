package model.util;

import java.util.ArrayList;

public interface Listable {
    ArrayList<?> loadGroup(int offset, int limit);
    int getTotal();
}
