/*
   D-Bus Java Bindings
   Copyright (c) 2005-2006 Matthew Johnson

   This program is free software; you can redistribute it and/or modify it
   under the terms of either the GNU General Public License Version 2 or the
   Academic Free Licence Version 2.1.

   Full licence texts are included in the COPYING file with this program.
*/
package org.freedesktop.dbus.test;

import org.freedesktop.dbus.DBusException;
import org.freedesktop.dbus.DBusInterface;
import org.freedesktop.dbus.DBusSignal;
import org.freedesktop.dbus.UInt32;
import org.freedesktop.dbus.Variant;
import org.freedesktop.DBus.Description;

import java.util.List;

/**
 * A sample signal with two parameters
 */
@Description("Test interface containing signals")
public interface TestSignalInterface extends DBusInterface
{
   @Description("Test basic signal")
   public static class TestSignal extends DBusSignal
   {
      public final String value;
      public final UInt32 number;
      /**
       * Create a signal.
       */
      public TestSignal(String path, String value, UInt32 number) throws DBusException
      {
         super(path, value, number);
         this.value = value;
         this.number = number;
      }
   }
   @Description("Test signal with arrays")
   public static class TestArraySignal extends DBusSignal
   {
      public final TestStruct2 v;
      public TestArraySignal(String path, TestStruct2 v) throws DBusException
      {
         super(path, v);
         this.v = v;
      }
   }
   @Description("Test signal sending an object path")
   public static class TestObjectSignal extends DBusSignal
   {
      public final DBusInterface otherpath;
      public TestObjectSignal(String path, DBusInterface otherpath) throws DBusException
      {
         super(path, otherpath);
         this.otherpath = otherpath;
      }
   }
}
