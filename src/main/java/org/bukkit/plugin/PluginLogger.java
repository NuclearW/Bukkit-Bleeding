//    Copyright (C) 2011  Ryan Michela
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program.  If not, see <http://www.gnu.org/licenses/>.

package org.bukkit.plugin;

import java.util.ResourceBundle;
import java.util.logging.*;

/**
 * The PluginLogger class is a modified {@link java.util.logging.Logger} that prepends all logging calls with the name of the
 * plugin doing the logging.
 * 
 * The API for PluginLogger is exactly the same as {@link java.util.logging.Logger}.
 */
public class PluginLogger extends Logger {

    private String pluginName;
    private Logger base;

    /**
     * Creates a new PluginLogger that extracts the name from a plugin.
     * @param context
     */
    public PluginLogger(Plugin context) {
        super(null, null);
        pluginName = "[" + context.getDescription().getName() + "] ";
        base = context.getServer().getLogger();
    }

    /**
     * @see java.util.logging.Logger#addHandler(java.util.logging.Handler)
     */
    @Override
    public void addHandler(Handler handler) throws SecurityException {
        base.addHandler(handler);     
    }

    /**
     * @see java.util.logging.Logger#config(String)
     */
    @Override
    public void config(String s) {
        base.config(s);     
    }

    /**
     * @see java.util.logging.Logger#entering(String, String)
     */
    @Override
    public void entering(String className, String methodName) {
        entering(className, methodName, new Object[0]);
    }

    /**
     * @see java.util.logging.Logger#entering(String, String, Object)
     */
    @Override
    public void entering(String className, String methodName, Object parameter) {
        Object[] parameters = {parameter};
        entering(className, methodName, parameters);
    }

    /**
     * @see java.util.logging.Logger#entering(String, String, Object[])
     */
    @Override
    public void entering(String className, String methodName, Object... parameters) {
        StringBuilder sb = new StringBuilder();
        sb.append("ENTRY  ").append(className).append(".").append(methodName).append("(");
        for (int i = 0; i < parameters.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(parameters[i]);
        }
        sb.append(")");
        finer(sb.toString());
    }

    /**
     * @see java.util.logging.Logger#exiting(String, String)
     */
    @Override
    public void exiting(String className, String methodName) {
        finer(String.format("RETURN %s.%s()", className, methodName));
    }

    /**
     * @see java.util.logging.Logger#exiting(String, String, Object)
     */
    @Override
    public void exiting(String className, String methodName, Object result) {
        finer(String.format("RETURN %s.%s() => %s", className, methodName, result));
    }

    /**
     * @see java.util.logging.Logger#fine(String)
     */
    @Override
    public void fine(String s) {
        base.fine(pluginName + s);
    }

    /**
     * @see java.util.logging.Logger#finer(String)
     */
    @Override
    public void finer(String s) {
        base.finer(pluginName + s);
    }

    /**
     * @see java.util.logging.Logger#finest(String)
     */
    @Override
    public void finest(String s) {
        base.finest(pluginName + s);
    }

    /**
     * @see java.util.logging.Logger#getFilter()
     */
    @Override
    public Filter getFilter() {
        return base.getFilter();     
    }

    /**
     * @see java.util.logging.Logger#getHandlers()
     */
    @Override
    public Handler[] getHandlers() {
        return base.getHandlers();     
    }

    /**
     * @see java.util.logging.Logger#getLevel()
     */
    @Override
    public Level getLevel() {
        return base.getLevel();     
    }

    /**
     * @see java.util.logging.Logger#getName()
     */
    @Override
    public String getName() {
        return base.getName();     
    }

    /**
     * @see java.util.logging.Logger#getParent()
     */
    @Override
    public Logger getParent() {
        return base.getParent();     
    }

    /**
     * @see java.util.logging.Logger#getResourceBundle()
     */
    @Override
    public ResourceBundle getResourceBundle() {
        return base.getResourceBundle();     
    }

    /**
     * @see java.util.logging.Logger#getResourceBundleName()
     */
    @Override
    public String getResourceBundleName() {
        return base.getResourceBundleName();     
    }

    /**
     * @see java.util.logging.Logger#getUseParentHandlers()
     */
    @Override
    public boolean getUseParentHandlers() {
        return base.getUseParentHandlers();     
    }

    /**
     * @see java.util.logging.Logger#info(String)
     */
    @Override
    public void info(String s) {
        base.info(pluginName + s);     
    }

    /**
     * @see java.util.logging.Logger#isLoggable(java.util.logging.Level)
     */
    @Override
    public boolean isLoggable(Level level) {
        return base.isLoggable(level);     
    }

    /**
     * @see java.util.logging.Logger#log(java.util.logging.Level, String)
     */
    @Override
    public void log(Level level, String s) {
        base.log(level, pluginName + s);     
    }

    /**
     * @see java.util.logging.Logger#log(java.util.logging.Level, String, Object)
     */
    @Override
    public void log(Level level, String s, Object o) {
        base.log(level, pluginName + s, o);     
    }

    /**
     * @see java.util.logging.Logger#log(java.util.logging.Level, String, Object[])
     */
    @Override
    public void log(Level level, String s, Object[] objects) {
        base.log(level, pluginName + s, objects);     
    }

    /**
     * @see java.util.logging.Logger#log(java.util.logging.Level, String, Throwable)
     */
    @Override
    public void log(Level level, String s, Throwable throwable) {
        base.log(level, pluginName + s, throwable);     
    }

    /**
     * @see java.util.logging.Logger#log(java.util.logging.LogRecord)
     */
    @Override
    public void log(LogRecord logRecord) {
        base.log(logRecord);     
    }

    /**
     * @see java.util.logging.Logger#logp(java.util.logging.Level, String, String, String)
     */
    @Override
    public void logp(Level level, String s, String s1, String s2) {
        base.logp(level, s, s1, pluginName + s2);     
    }

    /**
     * @see java.util.logging.Logger#logp(java.util.logging.Level, String, String, String, Object)
     */
    @Override
    public void logp(Level level, String s, String s1, String s2, Object o) {
        base.logp(level, s, s1, pluginName + s2, o);     
    }

    /**
     * @see java.util.logging.Logger#logp(java.util.logging.Level, String, String, String, Object[])
     */
    @Override
    public void logp(Level level, String s, String s1, String s2, Object[] objects) {
        base.logp(level, s, s1, pluginName + s2, objects);     
    }

    /**
     * @see java.util.logging.Logger#logp(java.util.logging.Level, String, String, String, Throwable)
     */
    @Override
    public void logp(Level level, String s, String s1, String s2, Throwable throwable) {
        base.logp(level, s, s1, pluginName + s2, throwable);     
    }

    /**
     * @see java.util.logging.Logger#logrb(java.util.logging.Level, String, String, String, String)
     */
    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3) {
        base.logrb(level, s, s1, s2, pluginName + s3);     
    }

    /**
     * @see java.util.logging.Logger#logrb(java.util.logging.Level, String, String, String, String, Object)
     */
    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3, Object o) {
        base.logrb(level, s, s1, s2, pluginName + s3, o);     
    }

    /**
     * @see java.util.logging.Logger#logrb(java.util.logging.Level, String, String, String, String, Object[])
     */
    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3, Object[] objects) {
        base.logrb(level, s, s1, s2, pluginName + s3, objects);     
    }

    /**
     * @see java.util.logging.Logger#logrb(java.util.logging.Level, String, String, String, String, Throwable)
     */
    @Override
    public void logrb(Level level, String s, String s1, String s2, String s3, Throwable throwable) {
        base.logrb(level, s, s1, s2, pluginName + s3, throwable);     
    }

    /**
     * @see java.util.logging.Logger#removeHandler(java.util.logging.Handler)
     */
    @Override
    public void removeHandler(Handler handler) throws SecurityException {
        base.removeHandler(handler);     
    }

    /**
     * @see java.util.logging.Logger#setFilter(java.util.logging.Filter)
     */
    @Override
    public void setFilter(Filter filter) throws SecurityException {
        base.setFilter(filter);     
    }

    /**
     * @see java.util.logging.Logger#setLevel(java.util.logging.Level)
     */
    @Override
    public void setLevel(Level level) throws SecurityException {
        base.setLevel(level);     
    }

    /**
     * @see java.util.logging.Logger#setParent(java.util.logging.Logger)
     */
    @Override
    public void setParent(Logger logger) {
        base.setParent(logger);     
    }

    /**
     * @see java.util.logging.Logger#setUseParentHandlers(boolean)
     */
    @Override
    public void setUseParentHandlers(boolean b) {
        base.setUseParentHandlers(b);     
    }

    /**
     * @see java.util.logging.Logger#severe(String)
     */
    @Override
    public void severe(String s) {
        base.severe(pluginName + s);     
    }

    /**
     * @see java.util.logging.Logger#throwing(String, String, Throwable)
     */
    @Override
    public void throwing(String className, String method, Throwable throwable) {
        finer(String.format("THROW  %s.%s()\n%s\n", className, method, throwable));
    }

    /**
     * @see java.util.logging.Logger#warning(String)
     */
    @Override
    public void warning(String s) {
        base.warning(pluginName + s);     
    }
}
