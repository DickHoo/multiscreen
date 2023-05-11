# multiScreen
Getting started
The first step is to include multiScreen into your project, for example:

1.Add configuration to app build.gradle file
~~~

~~~

2.lib usage

Example 1:MediaRouter
~~~
   private lateinit var mediaRouterMultiScreen: MultiScreen
   private lateinit var view:View
   
   mediaRouterMultiScreen = MultiScreen.getInstance().getMediaRouterBuilder(this).addView(view).builder()
   mediaRouterMultiScreen.showMediaRouter()
   mediaRouterMultiScreen.hideMediaRouter()
~~~

Example 2:DisplayManager
~~~
  private lateinit var displayManagerMultiScreen: MultiScreen
  private lateinit var view:View
  
  displayManagerMultiScreen = MultiScreen.getInstance().getDisplayManagerBuilder(this).addView(view).builder()
  displayManagerMultiScreen.showDisplayManager()
  displayManagerMultiScreen.hideDisplayManager()
  
~~~