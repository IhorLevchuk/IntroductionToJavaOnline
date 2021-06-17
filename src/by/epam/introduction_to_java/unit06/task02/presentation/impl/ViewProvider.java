package by.epam.introduction_to_java.unit06.task02.presentation.impl;

public class ViewProvider {
    private static final ViewProvider provider = new ViewProvider();

    NoteActionView noteActionView = new NoteActionView();

    private ViewProvider() {
    }

    public static ViewProvider getProvider(){
        return provider;
    }

    public NoteActionView getNoteActionView() {
        return noteActionView;
    }
}
