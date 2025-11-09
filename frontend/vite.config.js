import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'


export default defineConfig({
  plugins: [react()],
  base: "./",
  preview: {
    allowedHosts: ['rehearsalmanager-axn9.onrender.com'],
  },
})
