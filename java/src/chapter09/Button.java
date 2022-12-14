package chapter09;

public class Button {
    OnClickListener listener;

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }

    public void touch(){
        listener.onClick();
    }

    public interface OnClickListener{
        public abstract void onClick();
    }
}
