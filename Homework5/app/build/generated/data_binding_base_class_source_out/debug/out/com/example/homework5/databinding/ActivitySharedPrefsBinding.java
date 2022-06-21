// Generated by view binder compiler. Do not edit!
package com.example.homework5.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

public final class ActivitySharedPrefsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button deleteInt;

  @NonNull
  public final Button readSharedPrefs;

  @NonNull
  public final Button saveSharedPrefs;

  @NonNull
  public final TextView sharedPrefContent;

  @NonNull
  public final TextView sharedPrefEncryptedContent;

  @NonNull
  public final EditText sharedPrefsInput;

  private ActivitySharedPrefsBinding(@NonNull ConstraintLayout rootView, @NonNull Button deleteInt,
      @NonNull Button readSharedPrefs, @NonNull Button saveSharedPrefs,
      @NonNull TextView sharedPrefContent, @NonNull TextView sharedPrefEncryptedContent,
      @NonNull EditText sharedPrefsInput) {
    this.rootView = rootView;
    this.deleteInt = deleteInt;
    this.readSharedPrefs = readSharedPrefs;
    this.saveSharedPrefs = saveSharedPrefs;
    this.sharedPrefContent = sharedPrefContent;
    this.sharedPrefEncryptedContent = sharedPrefEncryptedContent;
    this.sharedPrefsInput = sharedPrefsInput;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySharedPrefsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySharedPrefsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_shared_prefs, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySharedPrefsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.deleteInt;
      Button deleteInt = ViewBindings.findChildViewById(rootView, id);
      if (deleteInt == null) {
        break missingId;
      }

      id = R.id.readSharedPrefs;
      Button readSharedPrefs = ViewBindings.findChildViewById(rootView, id);
      if (readSharedPrefs == null) {
        break missingId;
      }

      id = R.id.saveSharedPrefs;
      Button saveSharedPrefs = ViewBindings.findChildViewById(rootView, id);
      if (saveSharedPrefs == null) {
        break missingId;
      }

      id = R.id.sharedPrefContent;
      TextView sharedPrefContent = ViewBindings.findChildViewById(rootView, id);
      if (sharedPrefContent == null) {
        break missingId;
      }

      id = R.id.sharedPrefEncryptedContent;
      TextView sharedPrefEncryptedContent = ViewBindings.findChildViewById(rootView, id);
      if (sharedPrefEncryptedContent == null) {
        break missingId;
      }

      id = R.id.sharedPrefsInput;
      EditText sharedPrefsInput = ViewBindings.findChildViewById(rootView, id);
      if (sharedPrefsInput == null) {
        break missingId;
      }

      return new ActivitySharedPrefsBinding((ConstraintLayout) rootView, deleteInt, readSharedPrefs,
          saveSharedPrefs, sharedPrefContent, sharedPrefEncryptedContent, sharedPrefsInput);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}