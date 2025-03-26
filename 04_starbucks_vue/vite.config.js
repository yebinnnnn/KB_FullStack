import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';
import ViteImagemin from 'vite-plugin-imagemin';

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
    ViteImagemin({
      gifsicle: {
        //GIF 최적화
        optimizationLevel: 3,
        interlaced: true,
      },
      mozjpeg: {
        //JPEG 최적화
        quality: 80,
      },
      optipng: {
        // PNG 최적화
        optimizationLevel: 7,
      },
      pngquant: {
        //PNG 추가 최적화
        quality: [0.6, 0.8],
        speed: 4,
      },
      svgo: {
        //SVG 최적화
        plugins: [{ removeViewBox: false }, { cleanupIDs: false }],
      },
      webp: {
        //WebP 이미지 최적화
        quality: 75,
      },
    }),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
});
