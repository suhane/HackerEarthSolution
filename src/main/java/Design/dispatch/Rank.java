package Design.dispatch;

public enum Rank {

    RESPONDENT(0),MANAGER(1),DIRECTOR(2);
    int value;

    private Rank(int v) {
        value = v;
    }

    public static Rank getRankFromValue(int value) {
        switch (value) {
            case 0:
                return Rank.RESPONDENT;
            case 1:
                return Rank.MANAGER;
            case 2:
                return Rank.DIRECTOR;
            default:
                return null;
        }
    }
}
