import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { createSvgIconsPlugin } from 'vite-plugin-svg-icons';
import path from 'path' 
import { viteMockServe } from 'vite-plugin-mock'
import { UserConfigExport, ConfigEnv } from 'vite'

// https://vitejs.dev/config/
export default ({ command }: ConfigEnv): UserConfigExport => {
  return {
    plugins: [
      vue(),
      viteMockServe({
        mockPath: 'mock',
        enable: false,
      }),
      createSvgIconsPlugin({
        // 指定需要缓存的图标文件夹
        iconDirs: [path.resolve(process.cwd(), 'src/assets/icons')],
        // 指定symbolId格式
        symbolId: 'icon-[dir]-[name]',
    }),
    ],
    resolve: {
      alias: {
        "@": path.resolve("./src")
      }
    },
    css: {
      preprocessorOptions: {
        scss: {
          javascriptEnabled: true,
          additionalData: '@import "./src/style/variable.scss";',
        },
      },
    },
    server: {
      proxy: {
        //api是自行设置的请求前缀，任何请求路径以/api开头的请求将被代理到对应的target目标
        '/api': {
          target: 'http://localhost:8080',
          changeOrigin: true, //需要代理跨域
          rewrite: (path) => path.replace(/^\/api/, ''), //路径重写，把'/api'替换为''
        },
      },
    },
    
  }
}
// export default defineConfig({
//   plugins: [
//     vue(),
//     createSvgIconsPlugin({
//       // 指定需要缓存的图标文件夹
//       iconDirs: [path.resolve(process.cwd(), 'src/assets/icons')],
//       // 指定symbolId格式
//       symbolId: 'icon-[dir]-[name]',
//   }),
// ],
//   resolve: {
//     alias: {
//       "@": path.resolve("./src")
//     }
//   }
// })
