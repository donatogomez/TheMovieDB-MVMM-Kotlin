package io.donatogomez.themoviedb.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesManager @Inject constructor(@ApplicationContext private val context: Context) {
    companion object {
        private const val NUMBER_OF_APP_OPENED_KEY = "number_of_app_opened"
        private const val SHARED_PREFERENCE_FILE_NAME = "mi_fichero"
        private const val DEFAULT_NUMBER_OF_APP_OPENED = 0
    }

    private val preferences =
        context.getSharedPreferences(SHARED_PREFERENCE_FILE_NAME, Context.MODE_PRIVATE)
    private val editor = preferences.edit()

    fun getNumberOfAppOpened(): Int {
        return preferences.getInt(NUMBER_OF_APP_OPENED_KEY, DEFAULT_NUMBER_OF_APP_OPENED)
    }

    fun setNumberOfAppOpened(number: Int) {
        editor.putInt(NUMBER_OF_APP_OPENED_KEY, number).commit()
    }
}