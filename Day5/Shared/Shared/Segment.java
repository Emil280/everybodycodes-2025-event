package Shared;

public class Segment {
    Integer lowerVal;
    public Integer spineElement;
    Integer higherVal;
    Integer number;

    Segment (Integer num) {
        spineElement = num;
        number = num;
    }

    public void calcNum(){
        if (lowerVal != null && higherVal != null) {
            number = Integer.parseInt(Integer.toString(lowerVal).concat(Integer.toString(spineElement).concat(Integer.toString(higherVal))));
        } else if (lowerVal == null) {
            number = Integer.parseInt(Integer.toString(spineElement).concat(Integer.toString(higherVal)));
        } else if (higherVal == null) {
            number = Integer.parseInt(Integer.toString(spineElement).concat(Integer.toString(lowerVal)));
        } else {
            number = spineElement;
        }
    }

    public boolean checkLower(Integer val) {
        return lowerVal == null;
    }

    public boolean addLower(Integer val) {
        if (checkLower(val)) {
            lowerVal = val;
            calcNum();
            return true;
        }
        return false;
    }

    public boolean checkHigher(Integer val) {
        return higherVal == null;
    }

    public boolean addHigher(Integer val) {
        if (checkHigher(val)) {
            higherVal = val;
            calcNum();
            return true;
        }
        return false;
    }

    public Boolean addVal(Integer val) {
        if (val < spineElement) {
            return addLower(val);
        } else if (val > spineElement) {
            return addHigher(val);
        } else {
            return false;
        }
    }
}
