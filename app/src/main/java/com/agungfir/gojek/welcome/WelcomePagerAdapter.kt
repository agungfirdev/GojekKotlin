package com.agungfir.gojek.welcome

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.agungfir.gojek.R

class WelcomePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int = 6
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return WelcomeFragment(
                    R.drawable.img_splash_1,
                    "Selamat datang di Gojek!",
                    "Aplikasi yang bikin hidup kamu lebih nyaman. Siap bantuin semua kebutuhanmu, kapan pun."
                )
            }
            1 -> {
                return WelcomeFragment(
                    R.drawable.img_splash_2,
                    "Transportasi & logistik",
                    "Anterin kamu jalan atau ambilin barang lebih gampang tinggal ngeklik doang~"
                )
            }
            2 -> {
                return WelcomeFragment(
                    R.drawable.img_splash_3,
                    "Pesan makan & belanja",
                    "Lagi ngidam sesuatu? Gojek beliin gak pake lama."
                )
            }
            3 -> {
                return WelcomeFragment(
                    R.drawable.img_splash_4,
                    "Pembayaran",
                    "Bisa beli pulsa, bayar tagihan listrik atau air, dan juga transfer sana sini."
                )
            }
            4 -> {
                return WelcomeFragment(
                    R.drawable.img_splash_5,
                    "Berita & hiburan",
                    "Dari baca berita, main game, sampai nonton serial kesukaan. Ada semuanya~"
                )
            }
            5 -> {
                return WelcomeFragment(
                    R.drawable.img_splash_1,
                    "Jasa profesional",
                    "Konsultasi dokter asli dan beli obat tanpa harus keluar rumah."
                )
            }
            else -> {
                return WelcomeFragment(
                    R.drawable.img_splash_1,
                    "Kosong nih view pager!",
                    "Mohon maaf nih view pager kosong!"
                )
            }
        }
    }
}