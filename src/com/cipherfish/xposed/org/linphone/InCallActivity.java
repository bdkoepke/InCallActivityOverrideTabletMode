package com.cipherfish.xposed.org.linphone;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class InCallActivity implements IXposedHookLoadPackage {
	public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
		if (! lpparam.packageName.equals("org.linphone"))
			return;
		findAndHookMethod("org.linphone.InCallActivity", lpparam.classLoader, "isTablet", new XC_MethodHook() {
			@Override
			protected void afterHookedMethod(MethodHookParam param) throws Throwable {
				param.setResult(false);
			}
		});
	}
}
