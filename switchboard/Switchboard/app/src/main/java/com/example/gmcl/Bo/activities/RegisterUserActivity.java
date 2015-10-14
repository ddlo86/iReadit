package com.example.gmcl.Bo.activities;

import com.example.gmcl.Bo.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Activity which displays a registration screen to the user
 */

public class RegisterUserActivity extends Activity {

	/**
	 * Keep track of the login task to ensure we can cancel it if requested.
	 */
	private RegisterUserTask mAuthTask = null;

	// Values for username and password at the time of the login attempt.
	private String mEmail;
	private String mPassword;
	private String mPasswordConfirm;
	private String mFname;
	private String mLname;


	// UI references.

	private EditText mEmailView;
	private EditText mPasswordView;
	private EditText mPasswordConfirmView;
	private EditText mLnameView;
	private EditText mFnameView;
	private View mLoginFormView;
	private View mLoginStatusView;
	private TextView mLoginStatusMessageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_register);

		// Set up the login form.

		mEmailView = (EditText) findViewById(R.id.email);
		mFnameView = (EditText) findViewById(R.id.fname);
		mLnameView = (EditText) findViewById(R.id.lname);
		mPasswordView = (EditText) findViewById(R.id.password);
		mPasswordConfirmView = (EditText) findViewById(R.id.confirm_password);

		//TODO: Do this for final field
//		mPasswordView
//				.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//					@Override
//					public boolean onEditorAction(TextView textView, int id,
//							KeyEvent keyEvent) {
//						if (id == R.id.login || id == EditorInfo.IME_NULL) {
//							attemptLogin();
//							return true;
//						}
//						return false;
//					}
//				});

		mLoginFormView = findViewById(R.id.login_form);
		mLoginStatusView = findViewById(R.id.login_status);
		mLoginStatusMessageView = (TextView) findViewById(R.id.login_status_message);

		findViewById(R.id.registerButton).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						attemptLogin();
					}
				});
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		super.onCreateOptionsMenu(menu);
//		getMenuInflater().inflate(R.menu.register, menu);
//		return true;
//	}

	/**
	 * Attempts to sign in or register the account specified by the login form.
	 * If there are form errors (invalid email, missing fields, etc.), the
	 * errors are presented and no actual login attempt is made.
	 */
	public void attemptLogin() {
		if (mAuthTask != null) {
			return;
		}

		// Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);
		mFnameView.setError(null);
		mLnameView.setError(null);

		// Store values at the time of the login attempt.
		mEmail = mEmailView.getText().toString();
		mPassword = mPasswordView.getText().toString();
		mPasswordConfirm = mPasswordConfirmView.getText().toString();
		mFname = mFnameView.getText().toString();
		mLname = mLnameView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password.
		if (TextUtils.isEmpty(mPassword)) {
			mPasswordView.setError(getString(R.string.error_field_required));
			focusView = mPasswordView;
			cancel = true;
		} else if (mPassword.length() < 6) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(mEmail)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!mEmail.contains("@")) {
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}

		if(!mPassword.equals(mPasswordConfirm)) {

			mPasswordConfirmView.setError(getString(R.string.error_password_mismatch));
			focusView = mPasswordConfirmView;
			cancel = true;
		}

		if (cancel) {
			// There was an error; don't attempt login and focus the first
			// form field with an error.
			focusView.requestFocus();
		} else {
			// Show a progress spinner, and kick off a background task to
			// perform the user login attempt.
			mLoginStatusMessageView
					.setText(R.string.login_progress_registering);
			showProgress(true);
			mAuthTask = new RegisterUserTask();
			mAuthTask.execute((Void) null);

		}
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {

		// TODO: improve this entire method. Currently placeholder.

		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(
					android.R.integer.config_shortAnimTime);

			mLoginStatusView.setVisibility(View.VISIBLE);
			mLoginStatusView.animate().setDuration(shortAnimTime)
					.alpha(show ? 1 : 0)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginStatusView.setVisibility(show ? View.VISIBLE
									: View.GONE);
						}
					});

			mLoginFormView.setVisibility(View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime)
					.alpha(show ? 0 : 1)
					.setListener(new AnimatorListenerAdapter() {
						@Override
						public void onAnimationEnd(Animator animation) {
							mLoginFormView.setVisibility(show ? View.GONE
									: View.VISIBLE);
						}
					});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mLoginStatusView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	/**
	 * Represents an asynchronous login/registration task used to authenticate
	 * the user.
	 */
	//TODO: Class Deprecation here.
	public class RegisterUserTask extends AsyncTask<Void, Void, Boolean> {

		ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

		boolean is3G = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnectedOrConnecting();

		boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.isConnectedOrConnecting();

		@Override
		protected Boolean doInBackground(Void... params) {
			if (is3G || isWifi) {
				ParseUser user = new ParseUser();
				user.setUsername(mEmail);
				user.setPassword(mPassword);
				user.setEmail(mEmail);
				user.put("firstName", mLname);
				user.put("lastName", mFname);
				user.put("userType", 1); //Hardcoded Trucker = 1


                user.getObjectId();
				Log.d("RegisterActivity", "Username: " + mEmail
						+ ", Email: " + mEmail + "Password: " + mPassword
						+ ", firstName: " + mFname + ", lastName: " + mLname);

				user.signUpInBackground(new SignUpCallback() {
					public void done(ParseException e) {
						if (e == null) {
							Log.d("RegisterActivity",
                                    "User registered successfully");

                            //TODO: Can we combine this and the signup into just one call?

                            ParseQuery<ParseObject> query = ParseQuery.getQuery("_User");
                            query.whereEqualTo("username", mEmail);
                            query.findInBackground(new FindCallback<ParseObject>() {
                                    public void done(List<ParseObject> users, ParseException e) {
                                        if(e == null) {

                                            //TODO: Error check if more than 1 user
                                            ParseObject trucker = new ParseObject("Trucker");
                                            trucker.put("userId", users.get(0).getObjectId());
                                            trucker.put("trailerType", "1");
                                            //TODO: Add GeoPoint
                                            trucker.saveInBackground();

                                        } else {
                                            //TODO: Execption
                                            Log.d("User Registration", "Error: " + e.getMessage());
                                        }
                                    }
                            });

                            //TODO: Send Activation Email
							Toast.makeText(getBaseContext(), getString(R.string.message_registration_success), Toast.LENGTH_LONG).show();

                            finish();
						} else {
							Toast.makeText(getBaseContext(), e.getMessage(),
									Toast.LENGTH_LONG).show();

							Log.d("RegisterActivity", e.getMessage());
						}
					}
				});

			} else {
				
				Toast.makeText(getBaseContext(), "No Internet Connection Available", Toast.LENGTH_LONG).show();
				return false;
			}
			return false;
		}

		@Override
		protected void onPostExecute(final Boolean success) {

			showProgress(false);

		}

		@Override
		protected void onCancelled() {
			mAuthTask = null;
			showProgress(false);
		}
	}
}
