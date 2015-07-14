package com.ee.libOne

import com.ee.libTwo

object Main{
  def ping = s"lib one says hi :: ${libTwo.Main.ping}"
}