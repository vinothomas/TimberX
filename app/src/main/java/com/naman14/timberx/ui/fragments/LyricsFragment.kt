/*
 * Copyright (c) 2019 Naman Dwivedi.
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 */
package com.naman14.timberx.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.naman14.timberx.R
import com.naman14.timberx.constants.Constants.ARTIST
import com.naman14.timberx.constants.Constants.SONG
import com.naman14.timberx.databinding.FragmentLyricsBinding
import com.naman14.timberx.extensions.argument
import com.naman14.timberx.extensions.disposeOnDetach
import com.naman14.timberx.extensions.inflateWithBinding
import com.naman14.timberx.extensions.ioToMain
import com.naman14.timberx.extensions.subscribeForOutcome
import com.naman14.timberx.network.Outcome
import com.naman14.timberx.network.api.LyricsRestService
import com.naman14.timberx.ui.fragments.base.BaseNowPlayingFragment
import com.naman14.timberx.util.AutoClearedValue
import org.koin.android.ext.android.inject

class LyricsFragment : BaseNowPlayingFragment() {
    companion object {
        fun newInstance(artist: String, title: String): LyricsFragment {
            return LyricsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARTIST, artist)
                    putString(SONG, title)
                }
            }
        }
    }

    private lateinit var artistName: String
    lateinit var songTitle: String
    var binding by AutoClearedValue<FragmentLyricsBinding>(this)

    private val lyricsService by inject<LyricsRestService>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflater.inflateWithBinding(R.layout.fragment_lyrics, container)
        artistName = argument(ARTIST)
        songTitle = argument(SONG)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.songTitle = songTitle

        var testLyric = "Male : Narumugayae narumugayae nee oru naaligai nillaai\n" +
                "Sengani ooriya vaai thiranthu nee oru thiru mozhi sollaai\n" +
                "Attrai thingal annillavil netri tharala neer vadiya\n" +
                "Kottra poigal aadiyaval neeya\n" +
                "Attrai thingal annillavil netri tharala neer vadiya\n" +
                "Kottra poigal aadiyaval neeya\n" +
                "\n" +
                "Female : Thirumaganae thirumaganae nee oru naaligai paarai\n" +
                "Vennira puraviyil vanthavanae vel vizhi mozhigal kellaai\n" +
                "Attrai thingal annilavil kottra poigai aadugaiyil\n" +
                "Ottrai paarvai paarthavannum neeya\n" +
                "Attrai thingal annilavil kottra poigai aadugaiyil\n" +
                "Ottrai paarvai paarthavannum neeya\n" +
                "\n" +
                "Male : Mangai maanvizhi ambugal en maarthulaitha thenna\n" +
                "Mangai maanvizhi ambugal en maarthulaitha thenna\n" +
                "Female : Paandi naadanai kanda en mannam passalai konda thenna\n" +
                "Male : Nillaavilae paartha vannum kanaavilae thondrum innum\n" +
                "Nillaavilae paartha vannum kanaavilae thondrum innum\n" +
                "Female : Illaithen thudithen porruka villai\n" +
                "Idaiyinil megallai irrukavillai\n" +
                "\n" +
                "Male : Narumugayae narumugayae nee oru naaligai nillaai\n" +
                "Sengani ooriya vaai thiranthu nee oru thiru mozhi sollaai\n" +
                "Female : Attrai thingal annilavil kottra poigai aadugaiyil\n" +
                "Ottrai paarvai paarthavannum neeya\n" +
                "Male : Attrai thingal annillavil netri tharala neer vadiya\n" +
                "Kottra poigal aadiyaval neeya\n" +
                "\n" +
                "Female : Yaayum yaayum yaaragiyaro nenjil nendrathenna\n" +
                "Yaayum yaayum yaaragiyaro nenjil nendrathenna\n" +
                "Male : Yaanum neeyum yevalli-aridhum ooravu serndhathenna\n" +
                "Female : Orae oru theendal seithaai ooyir kodi pootha thenna\n" +
                "Orae oru theendal seithaai ooyir kodi pootha thenna\n" +
                "Male : Sembullam serndhaa neer thulli pol\n" +
                "Ambudai nenjam kallantha thenna\n" +
                "\n" +
                "Female : Thirumaganae thirumaganae nee oru naaligai paarai\n" +
                "Vennira puraviyil vanthavanae vel vizhi mozhigal kellaai\n" +
                "Attrai thingal annilavil kottra poigai aadugaiyil\n" +
                "Ottrai paarvai paarthavannum neeya\n" +
                "Attrai thingal annilavil kottra poigai aadugaiyil\n" +
                "Ottrai paarvai paarthavannum neeya\n" +
                "\n" +
                "Male : Attrai thingal annillavil netri tharala neer vadiya\n" +
                "Kottra poigal aadiyaval neeya\n" +
                "Female : Aa aaa aaaaaaa…\n" +
                "Male : Neeya..\n" +
                "Female : Aa aaa aaaaaaa..\n" +
                "Male : Neeya..\n" +
                "Female : Aa aaa aaaaaaa..\n" +
                "Male : Neeya..";

        // TODO make the lyrics handler/repo injectable
       /* lyricsService.getLyrics(artistName, songTitle)
                .ioToMain()
                .subscribeForOutcome { outcome ->
                    when (outcome) {
                        is Outcome.Success -> binding.lyrics = outcome.data
                    }
                }
                .disposeOnDetach(view)*/
        binding.lyrics = testLyric;
    }
}
