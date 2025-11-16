/*
 * Copyright 2017 Google Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.ar.core.examples.java.common.helpers;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/** Helper to set up the Android full screen mode. */
public final class FullScreenHelper {
  /**
   * Sets the Android fullscreen flags. Expected to be called from {@link
   * Activity#onWindowFocusChanged(boolean hasFocus)}.
   *
   * @param activity the Activity on which the full screen mode will be set.
   * @param hasFocus the hasFocus flag passed from the {@link Activity#onWindowFocusChanged(boolean
   *     hasFocus)} callback.
   */
  public static void setFullScreenOnWindowFocusChanged(Activity activity, boolean hasFocus) {
    if (hasFocus) {
      Window window = activity.getWindow();
      
      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        // Use modern WindowInsetsController for API 30+
        WindowInsetsController controller = window.getInsetsController();
        if (controller != null) {
          controller.hide(WindowInsetsCompat.Type.systemBars());
          controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        }
      } else {
        // Use WindowInsetsControllerCompat for compatibility
        WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, window.getDecorView());
        controller.hide(WindowInsetsCompat.Type.systemBars());
        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
      }
    }
  }
}
