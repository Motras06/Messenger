package messenger.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import messenger.ui.registration.R;

public class AutorizationFragment extends Fragment {

    public AutorizationFragment() {
    }

    EditText text_email;
    EditText text_password;
    Button button_go;
    TextView reg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_autorization, container, false);
        text_email = (EditText) view.findViewById(R.id.mail_enter);
        text_password = (EditText) view.findViewById(R.id.password_enter);
        button_go = (Button) view.findViewById(R.id.button_enter);
        reg = (TextView) view.findViewById(R.id.go_to_reg);
        return view;
    }
}