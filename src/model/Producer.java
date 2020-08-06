package model;

public class Producer {
    String nameProducer, national, rankOfWorld;

    public Producer() {
    }

    public Producer(String nameProducer, String national, String rankOfWorld) {
        this.nameProducer = nameProducer;
        this.national = national;
        this.rankOfWorld = rankOfWorld;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getRankOfWorld() {
        return rankOfWorld;
    }

    public void setRankOfWorld(String rankOfWorld) {
        this.rankOfWorld = rankOfWorld;
    }

    public void showInfo() {
        System.out.println("Producer : " + nameProducer);
        System.out.println("National : " + national);
        System.out.println("Rank of world : " + rankOfWorld);
    }

    public String fileData() {
        String data = nameProducer + "|" + national + "|" + rankOfWorld;
        return data;
    }
}
