package code.spellcraft;

import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class UnorderedArrayList<T> extends ArrayList<T> {

    public UnorderedArrayList() {super();}
    public UnorderedArrayList(int size) {
        super(size);
    }


    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UnorderedArrayList)) {
            return false;
        } else {
            UnorderedArrayList array = (UnorderedArrayList) object;
            if (array.size() != this.size()) {
                return false;
            } else {
                for (Object o : this) {
                    if (!array.contains(o)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

}
