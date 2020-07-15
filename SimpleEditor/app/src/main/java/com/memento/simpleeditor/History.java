package com.memento.simpleeditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<>();

    public void push(EditorState state) {
        states.add(state);
    }

    public EditorState pop() {
        int lastIndex = states.size() - 1;
        EditorState editorState = states.get(lastIndex);

        states.remove(lastIndex);

        return editorState;
    }

    public int size() {
        return states.size();
    }

    public List<List<EditorState>> debugHistory() {
        return Arrays.asList(states);
    }
}
