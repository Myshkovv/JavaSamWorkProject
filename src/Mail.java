

class Mail extends Item {
    private String text;

    public Mail(String name, String text) {
        super(name);
        this.text = text;
    }

    public String getText() {
        return text;
    }
}