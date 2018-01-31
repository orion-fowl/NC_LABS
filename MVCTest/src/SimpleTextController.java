import java.util.Objects;

public class SimpleTextController implements TextViewController, TextViewObserver{
	private TextView view;
	private TextModel model;
	
	public SimpleTextController(TextView view, TextModel model) {
		this.view = Objects.requireNonNull(view, "Text view can not be null.");
		this.model = Objects.requireNonNull(model, "Text model can not be null.");
		view.addTextObserver(this);
	}
	
	@Override
	public void textWasChanged(TextView view) {
		getTextModel().setText(view.getText());
	}

	@Override
	public TextView getTextView() {
		return view;
	}

	@Override
	public TextModel getTextModel() {
		return model;
	}

}
