public class MainActivity extends Activity {
  private GestureOverlayView gov;
  private Gesture gesture;
  private GestureLibrary gestureLib;
  private TextView tv;
  private EditText et;
  private String path;
  private File file; 
  
  
  public void Oncreat(){
    super.onCreate()
    setContentView(R.layout.main);
    textview =(TextView) findViewById(R.id.?);
    editview =(EditText)findViewById(R.id.?);
    gestview =(GesttureOverlayView)findViewById(R.id.?);
    gestview.setGestureStrokeType(GesttureOverlayview.GESTURE_SROKE_TYPE_SINGLE);
    path = new File( ) 
    file = new File(path);
    gestureLib = GestureLibraries.fromFile(path);
    gov.addOnGestureListener(new OnGestureListener() {
      public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {
        textview.setText();
      }
      public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {
  					gesture = overlay.getGesture();
            if (gesture.getStrokesCount() == 1) {
              if (event.getAction() == MotionEvent.ACTION_UP) {
                  if (et.getText().toString().equals("")) {
									tv.setText(" 请输入手势名称再保存 ");
								} else {
									tv.setText("正在保存手势...");
									addMyGesture(et.getText().toString(), gesture); 
								}
							}
            }else{
              
            }});
            
          if(!getureLib.load()){
            
          }else {
  		         Set<String> set = gestureLib.getGestureEntries(); 
		        	Object ob[] = set.toArray();
		        	loadAllGesture(set, ob);
		}
      }
     
  public void loadAllGesture(Set<String> set, Object ob[]) { 
		if (gestureLib.load()) { 
			set = gestureLib.getGestureEntries(); 
			ob = set.toArray();
			for (int i = 0; i < ob.length; i++) {
		 
				gestureToImage(gestureLib.getGestures((String) ob[i]).get(0));
			 
				MySurfaceView.vec_string.addElement((String) ob[i]);
			}
		}
	}

	public void gestureToImage(Gesture ges) { 
	 
		if (MySurfaceView.vec_bmp != null) {
			MySurfaceView.vec_bmp.addElement(ges.toBitmap(100, 100, 12, Color.GREEN));
		}
	}

	public void findGesture(Gesture gesture) {
	 
			if (Environment.getExternalStorageState() != null) { 
				if (!file.exists()) { 
				} else { 
					if (!gestureLib.load()) { 				 
					} else {
						List<Prediction> predictions = gestureLib.recognize(gesture);		 
						if (!predictions.isEmpty()) {
							Prediction prediction = predictions.get(0);		 
							if (prediction.score >= 1) {								 
							}
						}
					}
				}
			} else {			 
			}
	}       
}
