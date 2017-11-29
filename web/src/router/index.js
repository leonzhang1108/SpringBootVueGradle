import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ComponentDemo from '@/components/ComponentDemo'
import Tree from '@/components/Tree'
import Canvas from '@/components/Canvas'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }, {
      path: '/canvas',
      name: 'canvas',
      component: Canvas
    }, {
      path: '/tree',
      name: 'tree',
      component: Tree
    }, {
      path: '/componentdemo',
      name: 'componentdemo',
      component: ComponentDemo
    }
  ]
})
