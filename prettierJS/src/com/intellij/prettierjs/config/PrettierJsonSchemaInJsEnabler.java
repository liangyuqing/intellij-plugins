// Copyright 2000-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.intellij.prettierjs.config;

import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.prettierjs.PrettierUtil;
import com.jetbrains.jsonSchema.extension.JsonSchemaEnabler;

public class PrettierJsonSchemaInJsEnabler implements JsonSchemaEnabler {
  @Override
  public boolean isEnabledForFile(VirtualFile file) {
    return PrettierUtil.isJSConfigFile(file);
  }

  @Override
  public boolean shouldShowSwitcherWidget(VirtualFile file) {
    return false;
  }
}
