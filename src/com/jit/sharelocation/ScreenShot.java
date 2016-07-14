package com.jit.sharelocation;import java.io.File;import java.io.FileNotFoundException;import java.io.FileOutputStream;import java.io.IOException;import android.app.Activity;import android.graphics.Bitmap;import android.graphics.Canvas;import android.graphics.Rect;import android.view.View;import android.view.View.MeasureSpec;import android.widget.ListView;import android.widget.RelativeLayout;import android.widget.ScrollView;public class ScreenShot {		/**	 * 获取整个页面的截图	 * @param activity 页面	 * @param path     保存路径 	 * @return	 */	@SuppressWarnings("deprecation")	public static Bitmap takeScreenShot(Activity activity,String path) {		View view = activity.getWindow().getDecorView();		view.setDrawingCacheEnabled(true);		view.buildDrawingCache();		Bitmap b1 = view.getDrawingCache();		Rect frame = new Rect();		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);		int statusBarHeight = frame.top;		System.out.println(statusBarHeight);		int width = activity.getWindowManager().getDefaultDisplay().getWidth();		int height = activity.getWindowManager().getDefaultDisplay().getHeight();		Bitmap b = Bitmap.createBitmap(b1, 0, statusBarHeight, width, height - statusBarHeight);		view.destroyDrawingCache();		savePicByPNG(b, path);		return b;	}	/**	 * 保存图片到指定的路径，文件格式为PNG	 * @param b	 * @param fileName	 */	public static void savePicByPNG(Bitmap b, String fileName) {		FileOutputStream fos = null;		try {			if (!new File(fileName).exists()) {				new File(fileName).createNewFile();			}			fos = new FileOutputStream(fileName);			if (null != fos) {				b.compress(Bitmap.CompressFormat.PNG, 90, fos);				fos.flush();				fos.close();			}		} catch (FileNotFoundException e) {			e.printStackTrace();		} catch (IOException e) {			e.printStackTrace();		}	}		/**	 * 保存图片到指定的路径，文件格式为PNG	 * @param b	 * @param fileName	 */	public static void savePicbyJPG(Bitmap b, String fileName) {		FileOutputStream fos = null;		try {			fos = new FileOutputStream(fileName);			if (null != fos) {				b.compress(Bitmap.CompressFormat.JPEG, 90, fos);				fos.flush();				fos.close();			}		} catch (FileNotFoundException e) {			e.printStackTrace();		} catch (IOException e) {			e.printStackTrace();		}	}	/**	 * 获取指定View对应的Bitmap	 * @param view	 * @return	 */	public static Bitmap convertViewToBitmap(View view) {		view.measure(MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),				MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));		view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());		view.buildDrawingCache();		Bitmap bitmap = view.getDrawingCache();		return bitmap;	}	/**	 * 获取指定View对应的Bitmap	 * @param view	 * @return	 */	public static Bitmap getViewBitmap(View v) {		v.clearFocus();		v.setPressed(false);		boolean willNotCache = v.willNotCacheDrawing();		v.setWillNotCacheDrawing(false);		int color = v.getDrawingCacheBackgroundColor();		v.setDrawingCacheBackgroundColor(0);		if (color != 0) {			v.destroyDrawingCache();		}		v.buildDrawingCache();		Bitmap cacheBitmap = v.getDrawingCache();		if (cacheBitmap == null) {			return null;		}		Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);		v.destroyDrawingCache();		v.setWillNotCacheDrawing(willNotCache);		v.setDrawingCacheBackgroundColor(color);		return bitmap;	}	/**	 * 获取ScrollView对应的Bitmap	 * @param scrollView	 * @return	 */	public static Bitmap getBitmapByView(ScrollView scrollView) {		int h = 0;		Bitmap bitmap = null;		for (int i = 0; i < scrollView.getChildCount(); i++) {			h += scrollView.getChildAt(i).getHeight();		}		bitmap = Bitmap.createBitmap(scrollView.getWidth(), h, Bitmap.Config.RGB_565);		final Canvas canvas = new Canvas(bitmap);		scrollView.draw(canvas);		return bitmap;	}		/**	 * 获取RelativeLayout对应的Bitmap	 * @param relativeLayout	 * @return	 */	public static Bitmap getBitmapByView(RelativeLayout relativeLayout) {		int h = 0;		Bitmap bitmap = null;		for (int i = 0; i < relativeLayout.getChildCount(); i++) {			h += relativeLayout.getChildAt(i).getHeight();		}		bitmap = Bitmap.createBitmap(relativeLayout.getWidth(), h,				Bitmap.Config.RGB_565);		final Canvas canvas = new Canvas(bitmap);		relativeLayout.draw(canvas);		return bitmap;	}	/**	 * 获取ListView对应的Bitmap	 * @param listView	 * @return	 */	public static Bitmap getbBitmap(ListView listView) {		int h = 0;		Bitmap bitmap = null;		for (int i = 0; i < listView.getChildCount(); i++) {			h += listView.getChildAt(i).getHeight();		}		bitmap = Bitmap.createBitmap(listView.getWidth(), h,				Bitmap.Config.RGB_565);		final Canvas canvas = new Canvas(bitmap);		listView.draw(canvas);		return bitmap;	}}