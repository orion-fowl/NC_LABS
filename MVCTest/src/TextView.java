public interface TextView {
	public void setText(String text);
	public String getText();
	public void addTextObserver(TextViewObserver observer);
	public void removeTextObserver(TextViewObserver observer);
}
