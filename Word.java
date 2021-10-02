public class Word {
    public String word_target; // từ mới
    public String word_explain; // giai thich


    // ham khoi tao word
    public Word(String wordtarget, String explain) {
        this.word_target = wordtarget;
        this.word_explain = explain;
    }
    /**
     * phuong thuc getter, setter.
     */
    public String getWord_target() {
        return this.word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String toString() {
        return word_target + "\t\t" + word_explain;
    }
}
