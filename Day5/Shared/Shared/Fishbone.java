package Shared;

import java.util.ArrayList;

public class Fishbone {
    public ArrayList<Segment> fishbone = new ArrayList<>();
    public long quality = 0L;
    public int id;

    public Fishbone(int id) {
        this.id = id;
    }

    public Fishbone(){}

    public void addElement(Integer num) {
        if (fishbone.isEmpty()) {
            fishbone.add(new Segment(num));
            calcQuality();
        } else {
            int index = 0;
            boolean addedElement = false;
            while (!addedElement) {
                if (index < fishbone.size()) {
                    Segment curSeg = fishbone.get(index);
                    if (curSeg.addVal(num)) {
                        fishbone.set(index, curSeg);
                        addedElement = true;
                    } else {
                        index++;
                    }
                } else {
                    fishbone.add(new Segment(num));
                    this.calcQuality();
                    addedElement = true;
                }
            }
        }
    }

    public void calcQuality(){
        String qualString = "";
        for (Segment seg: fishbone){
            qualString += Integer.toString(seg.spineElement);
        }
        this.quality = Long.parseLong(qualString);
    }

    public int compareTo(Fishbone o) {
        if (this.quality > o.quality) {
            return 1;
        } else if (this.quality < o.quality) {
            return -1;
        } else {
            int index = 0;
            while (index < this.fishbone.size()) {
                Segment curSeg1 = this.fishbone.get(index);
                Segment curSeg2 = o.fishbone.get(index);
                if (curSeg1.number > curSeg2.number) {
                    return 1;
                } else if (curSeg1.number < curSeg2.number) {
                    return -1;
                } else {
                    index++;
                }
            }
            if (this.id > o.id) {
                return 1;
            } else if (this.id < o.id) {
                return -1;
            }
            return 0;
        }
    }
}