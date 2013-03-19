

public class MySurfaceView extends SurfaceView implements Callback, Runnable {
  
  private SurfaceHolder sfh;
	private Paint mPaint;
  private Canvas mCanvas;
	public static Vector<String> vec_string;
	private int col;
  private Thread myThread;

	public MySurfaceView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		sfh = this.getHolder();
		sfh.addCallback(this);
		myThread = new Thread(this);
		this.setKeepScreenOn(true);
		setFocusable(true);
		vec_string = new Vector<String>();
		vec_bmp = new Vector<Bitmap>();
	}

	public void surfaceCreated(SurfaceHolder holder) {
		col = this.getWidth() / 100;
		myThread.start();
	}

	public void draw() {
		try {
			mCanvas = sfh.lockCanvas();
			if (mCanvas != null) {
				mCanvas.drawColor(Color.BLACK);
				if (vec_bmp != null && vec_bmp.size() != 0) {
					for (int i = 0; i < vec_bmp.size(); i++) {
						Bitmap bitmap = vec_bmp.elementAt(i);
						p.setStyle(Style.STROKE);
		
					}
				}			
			}
		} catch (Exception e) {
			 
		} finally {
			sfh.unlockCanvasAndPost(canvas);
		}
	}

	public boolean onKeyDown(int key, KeyEvent event) {
		return super.onKeyDown(key, event);
	}
	public boolean onTouchEvent(MotionEvent event) {
		return true;
	}

	public void run() {
		while (true) {
			draw();
			try {
				Thread.sleep(100);
			} catch (Exception ex) {
			}
		}
	}
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {	}

	public void surfaceDestroyed(SurfaceHolder holder) {	}
}
