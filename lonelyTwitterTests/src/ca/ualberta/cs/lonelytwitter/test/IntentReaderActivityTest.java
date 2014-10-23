package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:
    
   public void testSendText(){
	   Intent intent= new Intent();
	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Testing send text");
	   
	   setActivityIntent(intent);
	   
	   IntentReaderActivity ira = getActivity();
	   assertEquals(ira.getText(),"Testing send text");
	   
   }
       
   public void testDisplayText(){
	   Intent intent = new Intent();
	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Testing Display");
	   
	   setActivityIntent(intent);
	   
	   IntentReaderActivity ira = getActivity();
	   TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
	   
	   assertEquals(tv.getText(),"Testing Display");
   }
   
   public void testDoubleText(){
	   Intent intent = new Intent();
	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Testing Double");
	   intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
	   
	   setActivityIntent(intent);
	   
	   IntentReaderActivity ira = getActivity();
	   TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
	   
	   assertEquals(tv.getText(),"Testing DoubleTesting Double");
   }
   
   public void testReverseText(){
	   Intent intent = new Intent();
	   intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Test");
	   intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
	   
	   setActivityIntent(intent);
	   
	   IntentReaderActivity ira = getActivity();
	   TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
	   
	   assertEquals(tv.getText(),"tseT");
   }
   
   public void testDefault(){
	   Intent intent = new Intent();
	   
	   setActivityIntent(intent);
	   
	   IntentReaderActivity ira = getActivity();
	   TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
	   
	   assertEquals(tv.getText(),"default text");
	   
	   
   }
   
   public void testViewOnScreen(){
	   Intent intent = new Intent();
	   
	   setActivityIntent(intent);
	   
	   IntentReaderActivity ira = getActivity();
	   View test = ira.getWindow().getDecorView();
	   TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
	   ViewAsserts.assertOnScreen(test, tv);

	   
	   
   }
   
}
