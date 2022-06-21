// Generated by view binder compiler. Do not edit!
package com.example.homework5.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.homework5.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFirstBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button;

  @NonNull
  public final EditText edittext;

  @NonNull
  public final RadioButton raarrayobj;

  @NonNull
  public final RadioButton raboolean;

  @NonNull
  public final RadioGroup radiogroup;

  @NonNull
  public final RadioButton rastring;

  @NonNull
  public final TextView textView;

  private ActivityFirstBinding(@NonNull ConstraintLayout rootView, @NonNull Button button,
      @NonNull EditText edittext, @NonNull RadioButton raarrayobj, @NonNull RadioButton raboolean,
      @NonNull RadioGroup radiogroup, @NonNull RadioButton rastring, @NonNull TextView textView) {
    this.rootView = rootView;
    this.button = button;
    this.edittext = edittext;
    this.raarrayobj = raarrayobj;
    this.raboolean = raboolean;
    this.radiogroup = radiogroup;
    this.rastring = rastring;
    this.textView = textView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFirstBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFirstBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_first, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFirstBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      Button button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.edittext;
      EditText edittext = ViewBindings.findChildViewById(rootView, id);
      if (edittext == null) {
        break missingId;
      }

      id = R.id.raarrayobj;
      RadioButton raarrayobj = ViewBindings.findChildViewById(rootView, id);
      if (raarrayobj == null) {
        break missingId;
      }

      id = R.id.raboolean;
      RadioButton raboolean = ViewBindings.findChildViewById(rootView, id);
      if (raboolean == null) {
        break missingId;
      }

      id = R.id.radiogroup;
      RadioGroup radiogroup = ViewBindings.findChildViewById(rootView, id);
      if (radiogroup == null) {
        break missingId;
      }

      id = R.id.rastring;
      RadioButton rastring = ViewBindings.findChildViewById(rootView, id);
      if (rastring == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      return new ActivityFirstBinding((ConstraintLayout) rootView, button, edittext, raarrayobj,
          raboolean, radiogroup, rastring, textView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}